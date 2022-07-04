package com.zxs.study.leetcode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 链接：https://leetcode.cn/problems/add-two-numbers
 *
 * @author s1mp1e
 * @date 1/7/2022
 */
public class Question2 {


    public static void main(String[] args) {

        Question2 question2 = new Question2();

        int[] nums1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        ListNode l1 = question2.createListNode(nums1);
        int[] nums2 = new int[]{9, 9, 9, 9};
        ListNode l2 = question2.createListNode(nums2);

        ListNode result = question2.addTwoNumbers2(l1, l2);
        System.out.println(result);


    }

    private static final ThreadLocal<Boolean> local = ThreadLocal.withInitial(() -> false);

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            ListNode node = new ListNode(sum % 10);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            if (sum > 10) {
                carry = 1;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return head;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        boolean canReturn = false;
        ListNode result = new ListNode();
        if (l1 == null && l2 == null) {
            sum = 0;
            canReturn = true;
        } else if (l1 == null) {
            sum = l2.val;
        } else if (l2 == null) {
            sum = l1.val;
        } else {
            sum = l1.val + l2.val;
        }
        if (local.get()) {
            sum += 1;
        }
        if (sum >= 10) {
            result.val = sum % 10;
            local.set(true);
        } else {
            result.val = sum;
            local.set(false);
        }
        if (canReturn && sum == 0) {
            return null;
        } else {
            result.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
            return result;
        }
    }


    private ListNode createListNode(int[] nums) {
        ListNode listNode = new ListNode(nums[0]);
        ListNode current = listNode;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            current.next = next;
            current = next;
        }
        return listNode;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(val);
            ListNode nextNode = next;
            while (nextNode != null) {
                stringBuilder.append(nextNode.val);
                nextNode = nextNode.next;
            }
            return stringBuilder.toString();
        }
    }
}
