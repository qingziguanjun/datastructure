package com.leetcode.fenzhihuisu;

import com.algs4.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-08-11 10:17
 * @Description:
 */
public class S78Subset {
    /**
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     * ? [1],
     * ? [2],
     * ? [1,2,3],
     * ? [1,3],
     * ? [2,3],
     * ? [1,2],
     * ? []
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        helper(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int level) {
        //if(result.size() == level){

        System.out.println(getPrefix(level) + "level == " + level + "   list = " + list);
        if(level == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        helper(result, nums, list, level + 1);
        list.add(nums[level]);
        helper(result, nums, list, level + 1);
        list.remove(list.size() -1 );
    }

    private String getPrefix(int level){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < level; i++){
            sb.append("       ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        S78Subset s78Subset = new S78Subset();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = s78Subset.subsetsIter(nums);
        System.out.println(subsets);
    }

    /**
     * 作者：LeetCode
     *     链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsIter(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }










}
