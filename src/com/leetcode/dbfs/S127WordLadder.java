package com.leetcode.dbfs;

import java.util.*;

/**
 * @author songyi
 * @date 2020-11-23 10:31
 * @Description: 作者：LeetCode-Solution
 *     链接：https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode-solution/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class S127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll(); //取出队头单词
            int path  = map.get(word); //获取到该单词的路径长度
            for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
                char[] chars = word.toCharArray(); //将单词转换为char array，方便替换
                for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
                    chars[i] = k; //替换第i个字符
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        System.out.println(map);
                        queue.offer(newWord);//加入队尾
                    }
                }
            }
        }
        return 0; //未找到
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
