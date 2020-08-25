package com.leetcode.fenzhihuisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-08-11 11:40
 * @Description:
 */
public class S46Permutations {

    /**
     *  ���ߣ�labuladong
     *     ���ӣ�https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
     *     ��Դ�����ۣ�LeetCode��
     *     ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     */
    List<List<Integer>> res = new LinkedList<>();

    /* ������������һ�鲻�ظ������֣��������ǵ�ȫ���� */
    List<List<Integer>> permute(int[] nums) {
        // ��¼��·����
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // ·������¼�� track ��
    // ѡ���б�nums �в������� track ����ЩԪ��
    // ����������nums �е�Ԫ��ȫ���� track �г���
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // ������������
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // �ų����Ϸ���ѡ��
            if (track.contains(nums[i])) {
                continue;
            }
            // ��ѡ��
            track.add(nums[i]);
            // ������һ�������
            backtrack(nums, track);
            // ȡ��ѡ��
            track.removeLast();
        }
    }



    /**
     * ����: [1,2,3]
     * ���:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/permutations
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     */

    /**
     * ���ӣ�https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        // ����������
        int len = nums.length;
        // ʹ��һ����̬���鱣�����п��ܵ�ȫ����
        //List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums,path, used);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used) {
        //��ֹ����
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //����ǰ��
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                System.out.println(path);
                path.add(nums[i]);
                used[i] = true;

                //��һ��
                dfs(nums, path, used);
                // ע�⣺������״̬���ã��Ǵ������ص�ǳ����Ĺ��̣���������ʽ�Ϻ͵ݹ�֮ǰ�ǶԳƵ�
                //�����ֳ�
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        S46Permutations solution = new S46Permutations();
        List<List<Integer>> lists = solution.permuteSelf(nums);
        System.out.println(lists);
    }


    //�Լ�д
    List<List<Integer>> myres = new ArrayList<>();
    public List<List<Integer>> permuteSelf(int[] nums){
        List<Integer>  stack = new ArrayList<>();

        mybackTrack(nums, stack);
        return  myres;

    }
    public  void mybackTrack(int[] nums, List<Integer> stack){
        if(stack.size() == nums.length){
            myres.add(new ArrayList<>(stack));
        }

        for(int i = 0; i < nums.length; i++){
            if(stack.contains(nums[i])){
                continue;
            }
            stack.add(nums[i]);
            mybackTrack(nums, stack);
            stack.remove(stack.size() -1 );
        }

    }

}
