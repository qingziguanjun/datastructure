package com.train20210423.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {
	private static final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static class Node {
		// node's fields.
		private String ipAddr;
		private int port;
		private String nodeName;

		public Node(String ipAddr, int port, String nodeName) {
			this.ipAddr = ipAddr;
			this.port = port;
			this.nodeName = nodeName;
		}

		public String toString() {
			return nodeName + ":<" + ipAddr + ":" + port + ">";
		}
	}

	private final SortedMap<Integer, Node> nodeMap = new TreeMap<Integer, Node>();
	private int[] hashVal;
	private int virtualNums;

	public ConsistentHashing(Node[] nodes, int virtualNums) {
		this.virtualNums = virtualNums;
		// ��ʼ��һ����Hash��
		for (Node node : nodes) {
			for (int i = 0; i < this.virtualNums; i++) {
				nodeMap.put(hash(node.toString() + i), node);
			}
		}
		Integer[] tmp = nodeMap.keySet().toArray(new Integer[0]);
		hashVal = copy(tmp);
	}

	public void add(Node node) {
		for (int i = 0; i < this.virtualNums; i++) {
			nodeMap.put(hash(node.toString() + i), node);
		}
		Integer[] tmp = nodeMap.keySet().toArray(new Integer[0]);
		hashVal = copy(tmp);
	}

	public void remove(Node node) {
		for (int i = 0; i < this.virtualNums; i++) {
			nodeMap.remove((hash(node.toString() + i)));
		}
		Integer[] tmp = nodeMap.keySet().toArray(new Integer[0]);
		hashVal = copy(tmp);
	}

	/**
	 * �����в�����һ�ڵ�������������������в���һ�����ڵ��ڵ�ǰֵ��Ԫ�أ���ȫ�Ķ��ֲ��ҡ� ���Ƿ���ֵ���ж�������ͬ��
	 * 
	 * @param key
	 * @return
	 */
	public Node getNode(String key) {
		int hash = hash(key);
		int low = 0, high = hashVal.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int midVal = hashVal[mid];
			if (midVal >= hash) {
				if (mid == 0 || hashVal[mid - 1] <= hash) {
					return nodeMap.get(midVal);
				}
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return nodeMap.get(hashVal[0]);
	}

	private int[] copy(Integer[] src) {
		int[] tmp = new int[src.length];
		for (int i = 0; i < tmp.length; i++)
			tmp[i] = src[i];
		return tmp;
	}

	private int hash(String key) {
		try {
			java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
			md5.update(key.getBytes());
			byte[] data = md5.digest();
			char[] charArr = new char[32];
			for (int i = 0; i < data.length; i++) {
				charArr[i * 2] = hex[data[i] >>> 4 & 0xF];
				charArr[i * 2 + 1] = hex[data[i] & 0xF];
			}
			return new String(charArr).hashCode();
		} catch (Exception e) {
			return Integer.MIN_VALUE;
		}
	}
    
	public static void main(String[] args) {
		//10��������
		Node[] nodes = new Node[10];
		Map<Node, List<String>> map = new HashMap<Node, List<String>>();

		// make nodes
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node("10.1.33.2" + i, 8070, "mynode" + i);
		}
		ConsistentHashing ch = new ConsistentHashing(nodes, 200);

		// make keys
		String[] keys = new String[1000000];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = "key" + (i * 17) + "ss" + i * 19;
		}

		// make results
		for (String key : keys) {
			Node n = ch.getNode(key);
			List<String> l = map.get(n);
			if (l == null) {
				l = new ArrayList<String>();
				map.put(n, l);
			}
			l.add(key);
		}
		//ͳ�Ʊ�׼������������ڵ�ĸ��ؾ�����
		double load[] = new double[nodes.length];
		int x=0;
		for (Iterator<Node> i = map.keySet().iterator(); i.hasNext();) {
			Node key = i.next();
			List<String> l = map.get(key);
			load[x++] = l.size();
		}
		System.out.println(variance(load));
	}
	
	//��׼��
    public static double variance(double[] data) {
        double variance = 0;
        double expect = sum(data) / data.length;
        for (int i = 0; i < data.length; i++) {
            variance = variance + (Math.pow((data[i] - expect), 2));
        }
        variance = variance / data.length;
        return Math.sqrt(variance);
    }
    
    private static double sum(double[] data) {
        double sum = 0;
        for (int i = 0; i < data.length; i++)
            sum = sum + data[i];
        return sum;
    }
}