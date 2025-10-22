package com.algorithms;

public class NumberOfZeroFilledSubArrays {
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
