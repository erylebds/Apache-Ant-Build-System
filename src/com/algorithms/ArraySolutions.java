package com.algorithms;

import com.algorithms.dataStructure.ListNode;

import java.util.*;

public class ArraySolutions {
    class MajorityElementll {

        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0) return result;

            int candidate1 = 0, candidate2 = 0;
            int count1 = 0, count2 = 0;

            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }

            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (num == candidate1) count1++;
                else if (num == candidate2) count2++;
            }

            int n = nums.length;
            if (count1 > n / 3) result.add(candidate1);
            if (count2 > n / 3) result.add(candidate2);

            return result;
        }
    }

    class MedianOfTwoSortedArrays {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int[] merged = new int[n1 + n2];

            int i = 0, j = 0, k = 0;

            while(i < n1 && j < n2){
                if (nums1[i] < nums2[j]){
                    merged[k++] = nums1[i++];
                } else {
                    merged[k++] = nums2[j++];
                }
            }
            while (i < n1){
                merged[k++] = nums1[i++];
            };
            while (j < n2){
                merged[k++] = nums2[j++];
            }

            int total = n1 + n2;
            if (total % 2 == 1){
                return merged[total / 2];
            } else {
                return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
            }
        }
    }

    class NumberOfZeroFilledSubArrays {
        public long zeroFilledSubarray(int[] nums) {
            long counter = 0;
            long total = 0;

            for(int i : nums){
                if (i == 0){
                    total++;
                    counter+=total;
                }else{
                    total=0;
                }
            }
            return counter;
        }
    }
    class RemoveDuplicatesFromSortedArray {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int writeIndex = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[writeIndex] = nums[i];
                    writeIndex++;
                }
            }
            return writeIndex;
        }
    }

    class RemoveElement {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int x: nums) {
                int count = freq.getOrDefault(x,0) + 1;
                if (count == 2) return true;
                freq.put(x, count);
            }
            return false;
        }
    }

    class TwoNumbers {
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
 //recommit
}
