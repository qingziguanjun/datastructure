package com.leetcode.dbfs;

import java.util.*;

/**
 * @author songyi
 * @date 2020-11-23 10:31
 * @Description: ���ߣ�LeetCode-Solution
 *     ���ӣ�https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode-solution/
 *     ��Դ�����ۣ�LeetCode��
 *     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 */
public class S127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //ת��Ϊhashset �ӿ��ٶ�
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //��������ж�
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); //bfs ����
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>(); //��¼���ʶ�Ӧ·������
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll(); //ȡ����ͷ����
            int path  = map.get(word); //��ȡ���õ��ʵ�·������
            for (int i = 0; i < word.length(); i++) { //�������ʵ�ÿ���ַ�
                char[] chars = word.toCharArray(); //������ת��Ϊchar array�������滻
                for (char k = 'a'; k <= 'z'; k++) { //��'a' �� 'z' �����滻
                    chars[i] = k; //�滻��i���ַ�
                    String newWord = String.valueOf(chars); //�õ��µ��ַ���
                    if (newWord.equals(endWord)) {  //����µ��ַ���ֵ��endWordһ�£����ص�ǰ����+1
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //����µ�����set�У�����û�з��ʹ�
                        map.put(newWord, path + 1); //��¼���ʶ�Ӧ��·������
                        System.out.println(map);
                        queue.offer(newWord);//�����β
                    }
                }
            }
        }
        return 0; //δ�ҵ�
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        S127WordLadder s = new S127WordLadder();
        int i = s.ladderLength(beginWord, endWord, Arrays.asList(words));
        System.out.println(i);

        //beginWord = "hit"
        //endWord = "cog"
        //wordList = ["hot","dot","dog","lot","log"]
    }

}
