package com.example.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _add_two_numbers {
    
    public static void main1(String[] args) {
        int[] num1 = new int[] {2, 4, 5};
        int[] num2 = new int[] {5, 6, 4};
        int[] num3 = addTwoNumbers1(num1, num2);

        // System.out.println(Math.pow(10, 2));

        int a = 324567;
        int num;
        while (a != 0) {
            num = a % 10; // 获取每一位
            a = a / 10; // 整数退一位
            System.out.println(num);
        }

    }

    public static int[] addTwoNumbers1(int[] num1, int[] num2) {
        String str1 = "";
        for (int i = num1.length - 1; i >= 0; i--) {
            str1 = str1 + num1[i];
        }
        int int1 = Integer.parseInt(str1);

        String str2 = "";
        for (int i = num2.length - 1; i >= 0; i--) {
            str2 = str2 + num2[i];
        }
        int int2 = Integer.parseInt(str2);

        int result = int1 + int2;
        int result_len = (result + "").length();
        List<Integer> result_list = new ArrayList<Integer>();

        for (int i = 0; i < result_len; i++) {
            int yu = (int) (Math.pow(10, (result_len - 1 - i)));
            int j = result % 10;
            result = result / 10;
            result_list.add(j);
        }
        System.out.println(result_list);
        // System.out.println(Arrays.toString(result_list));
        return null;
    }

    public static void main(String[] args) {
        _add_two_numbers this1 = new _add_two_numbers();
        ListNode l13 = this1.new ListNode(5);
        ListNode l12 = this1.new ListNode(4, l13);
        ListNode l11 = this1.new ListNode(2, l12);

        ListNode l23 = this1.new ListNode(4);
        ListNode l22 = this1.new ListNode(6, l23);
        ListNode l21 = this1.new ListNode(5, l22);

        ListNode result = this1.addTwoNumbers(l11, l21);
        // while (result.next != null){
        // System.out.println(result.val);
        // }
        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);
    }

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {

        };

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }


}
