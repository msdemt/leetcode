package com.example.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_two_sum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 4, 11, 3};
        int target = 6;
        int[] result = twoSum(nums, target);
    
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; ++i){
            if(hashtable.containsKey(target - nums[i])){
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
