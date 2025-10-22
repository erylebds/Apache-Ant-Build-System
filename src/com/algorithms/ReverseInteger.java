package com.algorithms;

public class ReverseInteger {
    public int reverse(int n) {
        int subX = n;
        int reversed = 0;

        if (n == 0) return n;

        while(subX != 0) {
            int lastDigit = subX % 10;
            subX /= 10;

            if (reversed > Integer.MAX_VALUE/10 || reversed < Integer.MIN_VALUE/10) {
                return 0;
            }

            reversed = reversed * 10 + lastDigit;
        }

        return reversed;
    }
}
