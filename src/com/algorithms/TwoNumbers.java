package com.algorithms;

import com.algorithms.dataStructure.ListNode;

public class TwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode(0);
        ListNode tail = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = 0;
            if (l1 != null) {
                digit1 = l1.val;
            }

            int digit2 = 0;
            if (l2 != null) {
                digit2 = l2.val;
            }

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        ListNode result = head.next;
        head.next = null;
        return result;
    }
}
