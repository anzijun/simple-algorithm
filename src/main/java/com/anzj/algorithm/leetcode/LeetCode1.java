package com.anzj.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode1 {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 简单比对
     * 每一个元素与随后各个元素逐一对比求和
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1 ;j < nums.length;j++){
                if((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    /**
     * 哈希表
     */
}
