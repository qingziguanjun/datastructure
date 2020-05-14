package com.leetcode.tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songyi
 * @date 2020-04-19 09:23
 * @Description:
 */
public class S501BTSMode {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        int[] t = {};
        if(root == null) return null;
        helper(root);
        int max = 0;
        for(Integer i : map.values()){
            if(i > max){
                max = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer i : map.keySet()){
            if(map.get(i).intValue() == max){
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;


    }
    public void helper(TreeNode root){
        Integer num = map.get(root.val);
        if(num == null){
            map.put(root.val, 1);
        }else {
            map.put(root.val, num+1);
        }
        findMode(root.left);
        findMode(root.right);
    }
}
