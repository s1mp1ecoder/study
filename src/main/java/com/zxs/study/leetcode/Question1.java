package com.zxs.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 链接：https://leetcode.cn/problems/two-sum
 */

public class Question1 {


    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(new Question1().twoSum(nums, target)));
    }


//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        HashMap<Integer, Integer> numsMap = new HashMap<>(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            if (!numsMap.containsKey(target - nums[i])) {
//                numsMap.put(nums[i], i);
//            } else {
//                result[0] = i;
//                result[1] = numsMap.get(target - nums[i]);
//                break;
//            }
//        }
//        return result;
//    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(target - nums[i])) {
                result[0] = i;
                result[1] = list.indexOf(target - nums[i]);
                break;
            } else {
                list.add(nums[i]);
            }
        }
        return result;
    }

}
