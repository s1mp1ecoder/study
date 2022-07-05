package com.zxs.study.leetcode;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 给定一个字符串s,请你找出其中不含有重复字符的 最长子串 的长度。
 * 滑动窗口
 * @author s1mp1e
 * @date 4/7/2022
 */
public class Question3 {


    public static void main(String[] args) {
        String s = "abcade";
        System.out.println(s.indexOf("a", 3));
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        int left = 0;
        int max = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                left = Math.max(left, map.get(character) + 1);
            }
            map.put(character, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> hashSet = new ArrayList<Integer>();
            hashSet.add((int) chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                int val = (int) chars[j];
                if (hashSet.contains(val)) {
                    break;
                }
                hashSet.add(val);
            }
            if (hashSet.size() > maxLength) {
                maxLength = hashSet.size();
            }
        }
        return maxLength;
    }


}
