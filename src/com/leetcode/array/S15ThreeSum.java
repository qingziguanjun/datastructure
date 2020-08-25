package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author songyi
 * @date 2020-07-24 11:36
 * @Description:https://leetcode-cn.com/problems/3sum/solution/yi-ge-fang-fa-tuan-mie-by-labuladong/
 */
public class S15ThreeSum {


    /**
     *
    vector<int> twoSum(vector<int>& nums, int target) {
        // 先对数组排序
        sort(nums.begin(), nums.end());
        // 左右指针
        int lo = 0, hi = nums.size() - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 根据 sum 和 target 的比较，移动左右指针
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else if (sum == target) {
                return {lo, hi};
            }
        }
        return {};
    }
     */

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3};
        S15ThreeSum sum = new S15ThreeSum();
        //System.out.println(sum.twoSumTarget(nums, 4));

        int[] nums2 = {1,1,1,2,3};
        // System.out.println(sum.threeSumTarget(nums2, 6));
        int[] nums3 = {-1, 0, 1, 2, -1, -4};
        System.out.println(sum.threeSum1(nums3));
        System.out.println(sum.threeSumFor(nums3));
    }


    /**
     * 这样的结果是有重复的
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> twoSumTarget1(int[] nums, int target) {
        // 先对数组排序
        List<List<Integer>>  res = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
        // 记录索引 lo 和 hi 最初对应的值
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 根据 sum 和 target 的比较，移动左右指针
            if      (sum < target) lo++;
            else if (sum > target) hi--;
            else {
                List<Integer> integers = Arrays.asList(nums[lo], nums[hi]);
                res.add(integers);
                lo++; hi--;
            }
        }
        return res;
    }

    /**
     * 去除重复的
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 记录索引 lo 和 hi 最初对应的值
            int left = nums[lo], right = nums[hi];
            if (sum < target) lo++;
            else if (sum > target) hi--;
            else {
                res.add(Arrays.asList(left, right));
                // 跳过所有重复的元素
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }


    List<List<Integer>> twoSumTargetOptimize(int[] nums, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        // nums 数组必须有序
        //sort(nums.begin(), nums.end());
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                res.add(Arrays.asList(left, right));
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }


    /* 计算数组 nums 中所有和为 target 的三元组 */
    List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // 数组得排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            //todo 从第1个开始， start = i+1,当前位置下一个开始右移动，为什么？
            //因为数组是排好序的，第i个用完了，为了避免重复也不能用了，如果找到了，所有跟第i个相关都找出来了，下一批找到的，就不需要第i个参与了
            //i直接向右移动即可。
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 记录索引 lo 和 hi 最初对应的值
            int left = nums[lo], right = nums[hi];
            if (sum < target) lo++;
            else if (sum > target) hi--;
            else {
                List<Integer> t = new ArrayList<>();
                t.add(left);
                t.add(right);
                res.add(t);
                // 跳过所有重复的元素
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }


    /**
     * 官方的解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                //todo nums[second] + nums[third] > target) 小于
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    /**
     * 这个代码太简洁了，佩服
     *     链接：https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            //当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 3 个数字都大于 0
            // ，在此固定指针 k 之后不可能再找到结果了。
            if(nums[k] > 0) break;
            //当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，
            // 本次双指针搜索只会得到重复组合。
                if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    // 当s < 0时，i += 1并跳过所有重复的nums[i]；
                    //其实不加上下面的while i< j,多判断，没用，和不为0的时候重复也会被忽略的
                    //while(i < j && nums[i] == nums[++i]);
                    ++i;
                } else if (sum > 0) {
                    // 当s > 0时，j -= 1并跳过所有重复的nums[j]；
                    //while(i < j && nums[j] == nums[--j]);
                    --j;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }


    /**
     * 三重for循环遍历
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumFor(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
//            if(nums[i+1] == nums[i]){
//                continue;
//            }

            for(int j= i +1; j < nums.length-1; j++){
               /* if(nums[j+1] == nums[j]){
                    continue;
                }*/
                for(int k = j+1; k < nums.length; k++){
                  /*  if(nums[k+1] == nums[k]){
                        continue;
                    }*/

                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }

                }
            }
        }



        return res;

    }



}
