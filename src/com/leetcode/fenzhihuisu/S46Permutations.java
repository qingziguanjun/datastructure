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
     *  作者：labuladong
     *     链接：https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }



    /**
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
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
        //终止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //处理当前层
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                System.out.println(path);
                path.add(nums[i]);
                used[i] = true;

                //下一层
                dfs(nums, path, used);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                //清理现场
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


    //自己写
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
