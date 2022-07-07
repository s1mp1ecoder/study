package com.zxs.study.leetcode;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate= -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,231−1]。本题中，如果除法结果溢出，则返回 231− 1
 * <p>
 * 链接：https://leetcode.cn/problems/xoh6Oh
 *
 * @author s1mp1e
 * @date 6/7/2022
 */
public class Question5 {

    public static void main(String[] args) {
        System.out.println(new Question5().divide(-3, 2));
    }


    public int divide(int a, int b) {
        if (a == 0x80000000 && b == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (a > 0) {
            negative--;
            a = -a;
        }
        if (b > 0) {
            negative--;
            b = -b;
        }
        int result = divideCore(a, b);
        return negative == 1 ? -result : result;
    }

    public int divideCore(int a, int b) {
        int result = 0;
        while (a <= b) {
            int value = b;
            int mod = 1;
            while (b >= 0xc0000000 && a <= value + value) {
                mod += mod;
                value += value;
            }
            result += mod;
            a -= value;
        }
        return result;
    }


}
