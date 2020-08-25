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
        // �ȶ���������
        sort(nums.begin(), nums.end());
        // ����ָ��
        int lo = 0, hi = nums.size() - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // ���� sum �� target �ıȽϣ��ƶ�����ָ��
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
     * �����Ľ�������ظ���
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> twoSumTarget1(int[] nums, int target) {
        // �ȶ���������
        List<List<Integer>>  res = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
        // ��¼���� lo �� hi �����Ӧ��ֵ
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // ���� sum �� target �ıȽϣ��ƶ�����ָ��
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
     * ȥ���ظ���
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // ��¼���� lo �� hi �����Ӧ��ֵ
            int left = nums[lo], right = nums[hi];
            if (sum < target) lo++;
            else if (sum > target) hi--;
            else {
                res.add(Arrays.asList(left, right));
                // ���������ظ���Ԫ��
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }


    List<List<Integer>> twoSumTargetOptimize(int[] nums, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        // nums �����������
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


    /* �������� nums �����к�Ϊ target ����Ԫ�� */
    List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // ������Ÿ���
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // ��� threeSum �ĵ�һ����
        for (int i = 0; i < n; i++) {
            // �� target - nums[i] ���� twoSum
            //todo �ӵ�1����ʼ�� start = i+1,��ǰλ����һ����ʼ���ƶ���Ϊʲô��
            //��Ϊ�������ź���ģ���i�������ˣ�Ϊ�˱����ظ�Ҳ�������ˣ�����ҵ��ˣ����и���i����ض��ҳ����ˣ���һ���ҵ��ģ��Ͳ���Ҫ��i��������
            //iֱ�������ƶ����ɡ�
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            // ����������������Ķ�Ԫ�飬�ټ��� nums[i] ���ǽ����Ԫ��
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // ������һ�������ظ�����������������ظ����
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // ��¼���� lo �� hi �����Ӧ��ֵ
            int left = nums[lo], right = nums[hi];
            if (sum < target) lo++;
            else if (sum > target) hi--;
            else {
                List<Integer> t = new ArrayList<>();
                t.add(left);
                t.add(right);
                res.add(t);
                // ���������ظ���Ԫ��
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }


    /**
     * �ٷ��Ľⷨ
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // ö�� a
        for (int first = 0; first < n; ++first) {
            // ��Ҫ����һ��ö�ٵ�������ͬ
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c ��Ӧ��ָ���ʼָ����������Ҷ�
            int third = n - 1;
            int target = -nums[first];
            // ö�� b
            for (int second = first + 1; second < n; ++second) {
                // ��Ҫ����һ��ö�ٵ�������ͬ
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // ��Ҫ��֤ b ��ָ���� c ��ָ������
                //todo nums[second] + nums[third] > target) С��
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // ���ָ���غϣ����� b ����������
                // �Ͳ��������� a+b+c=0 ���� b<c �� c �ˣ������˳�ѭ��
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
     * �������̫����ˣ����
     *     ���ӣ�https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            //�� nums[k] > 0 ʱֱ��break��������Ϊ nums[j] >= nums[i] >= nums[k] > 0���� 3 �����ֶ����� 0
            // ���ڴ˹̶�ָ�� k ֮�󲻿������ҵ�����ˡ�
            if(nums[k] > 0) break;
            //�� k > 0��nums[k] == nums[k - 1]ʱ��������Ԫ��nums[k]����Ϊ�Ѿ��� nums[k - 1] ��������ϼ��뵽����У�
            // ����˫ָ������ֻ��õ��ظ���ϡ�
                if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    // ��s < 0ʱ��i += 1�����������ظ���nums[i]��
                    //��ʵ�����������while i< j,���жϣ�û�ã��Ͳ�Ϊ0��ʱ���ظ�Ҳ�ᱻ���Ե�
                    //while(i < j && nums[i] == nums[++i]);
                    ++i;
                } else if (sum > 0) {
                    // ��s > 0ʱ��j -= 1�����������ظ���nums[j]��
                    //while(i < j && nums[j] == nums[--j]);
                    --j;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // ��s == 0ʱ����¼���[k, i, j]��res��ִ��i += 1��j -= 1�����������ظ���nums[i]��nums[j]����ֹ��¼���ظ���ϡ�
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }


    /**
     * ����forѭ������
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
