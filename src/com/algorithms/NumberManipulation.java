package com.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberManipulation {

    class FractionToRecurringDecimal {

        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";

            StringBuilder sb = new StringBuilder();

            if ((numerator < 0) ^ (denominator < 0)) {
                sb.append("-");
            }

            // Convert to long to avoid overflow
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);

            sb.append(num / den);
            long remainder = num % den;

            if (remainder == 0) return sb.toString();

            sb.append(".");
            Map<Long, Integer> map = new HashMap<>();

            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    int pos = map.get(remainder);
                    sb.insert(pos, "(");
                    sb.append(")");
                    break;
                }

                map.put(remainder, sb.length());
                remainder *= 10;
                sb.append(remainder / den);
                remainder %= den;
            }

            return sb.toString();
        }
    }

    class IntegerToRoman {
        public String intToRoman(int num) {
            int[] values  = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols  = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < values.length; i++){
                while (num >= values[i]){
                    sb.append(symbols[i]);
                    num -= values[i];
                }
            }
            return sb.toString();
        }
    }

    class NumberOfDigitOne {
        public int countDigitOne(int n) {
            int count = 0;
            long factor = 1;

            while (factor <= n) {
                long lower = n % factor;
                long curr = (n / factor) % 10;
                long higher = n / (factor * 10);

                if (curr == 0) {
                    count += higher * factor;
                } else if (curr == 1) {
                    count += higher * factor + lower + 1;
                } else {
                    count += (higher + 1) * factor;
                }
                factor *= 10;
            }
            return count;
        }
    }

    class PalindromeNumber {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int original = x;
            int reverse = 0;

            while (x > 0){
                reverse = (reverse * 10) + (x % 10);
                x /= 10;
            }
            return original == reverse;
        }
    }

    class PlusOne {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] newNumber = new int[n + 1];
            newNumber[0] = 1;
            return newNumber;
        }
    }

    class ReverseInteger {
        public int reverse(int n) {
            int subX = n;
            int reversed = 0;

            if (n == 0) return n;

            while (subX != 0) {
                int lastDigit = subX % 10;
                subX /= 10;

                if (reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
                    return 0;
                }

                reversed = reversed * 10 + lastDigit;
            }

            return reversed;
        }
    }

    class RomanToInteger {
        public int romanToInt(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int total = 0;

            for (int i = 0; i < s.length(); i++) {
                int value = map.get(s.charAt(i));
                if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > value) {
                    total -= value;
                } else {
                    total += value;
                }
            }
            return total;
        }
    }

    class SingleNumberIII {
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
}
