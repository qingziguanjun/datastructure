package com.leetcode.array;

import com.algs4.algs4.In;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author songyi
 * @date 2020-07-28 21:34
 * @Description: https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/solution/javaban-chao-jian-dan-jie-fa-by-wang_dong/
 */
public class S442DuplicateInArray {

    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     *
     * 找到所有出现两次的元素。
     *
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     *
     * 示例：
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [2,3]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
    //自己尝试hash
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[Math.abs(nums[i]) - 1];
            if(num < 0){
                result.add(num);
            }else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) -1];
            }

        }
        return result;


    }

    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        S442DuplicateInArray s = new S442DuplicateInArray();
        System.out.println(s.findDup(array));
        System.out.println(Arrays.toString(array));
    }



    public List<Integer> findDup(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int n = Math.abs(nums[i]);
            if(nums[n - 1] < 0){
                result.add(n);
            }
            nums[n-1] = -Math.abs(nums[n-1]);
        }
        return  result;
    }

}
