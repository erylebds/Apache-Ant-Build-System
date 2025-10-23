package com.algorithms;

public class RemoveElement {
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


