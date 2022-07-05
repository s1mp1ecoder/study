package com.zxs.study.leetcode;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和 。请你找出并返回这两个正序数组的中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 *
 * @author s1mp1e
 * @date 5/7/2022
 */
public class Question4 {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{6, 5};
        Question4 question4 = new Question4();
        System.out.println(question4.findMedianSortedArrays2(nums1, nums2));
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        double max = 0.0d;
        int left2 = 0;
        int i = 0;
        int[] totalNums = new int[nums1.length + nums2.length];

        for (int left1 = 0; left1 < nums1.length; left1++) {
            while (left2 < nums2.length && nums2[left2] < nums1[left1]) {
                totalNums[i] = nums2[left2++];
                i++;
            }
            totalNums[i] = nums1[left1];
            i++;
        }
        while (left2 < nums2.length) {
            totalNums[i] = nums2[left2];
            left2++;
            i++;
        }
        max = findMedianSortedSingleArray(totalNums);
        return max;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        } else if (nums1 == null) {
            return findMedianSortedSingleArray(nums2);
        } else if (nums2 == null) {
            return findMedianSortedSingleArray(nums1);
        } else {
            int totalLen = nums1.length + nums2.length;
            int[] totalArrays = new int[totalLen];
            System.arraycopy(nums1, 0, totalArrays, 0, nums1.length);
            System.arraycopy(nums2, 0, totalArrays, nums1.length, nums2.length);
            Arrays.sort(totalArrays);
            return findMedianSortedSingleArray(totalArrays);
        }
    }

    private double findMedianSortedSingleArray(int[] nums) {
        if (nums.length == 0) {
            return 0.0;
        }
        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[length / 2] + nums[(length / 2) - 1]) / 2.00000;
        } else {
            return nums[length / 2];
        }
    }


}
