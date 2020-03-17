package com.atguigu.datastructure.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		//����һ�� ArrBinaryTree
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		//arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
		arrBinaryTree.inOrder(0); // 4,2,5,1,6,3,7
	}

}

//��дһ��ArrayBinaryTree, ʵ��˳��洢����������

class ArrBinaryTree {
	private int[] arr;//�洢���ݽ�������

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	//����preOrder
	public void preOrder() {
		this.preOrder(0);
	}
	
	//��дһ�����������˳��洢��������ǰ�����
	/**
	 * 
	 * @param index ������±� 
	 */
	public void preOrder(int index) {
		//�������Ϊ�գ����� arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}
		//�����ǰ���Ԫ��
		System.out.println(arr[index]); 
		//����ݹ����
		if((index * 2 + 1) < arr.length) {
			preOrder(2 * index + 1 );
		}
		//���ҵݹ����
		if((index * 2 + 2) < arr.length) {
			preOrder(2 * index + 2);
		}
	}

	/**
	 *
	 * @param index ������±�
	 */
	public void inOrder(int index) {
		//�������Ϊ�գ����� arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}

		//����ݹ����
		if((index * 2 + 1) < arr.length) {
			inOrder(2 * index + 1 );
		}
		//�����ǰ���Ԫ��
		System.out.println(arr[index]);
		//���ҵݹ����
		if((index * 2 + 2) < arr.length) {
			preOrder(2 * index + 2);
		}
	}
}
