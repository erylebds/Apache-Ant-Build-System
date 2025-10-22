package com.algorithms;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int[] result = new int[2];
        int i=0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }

}
