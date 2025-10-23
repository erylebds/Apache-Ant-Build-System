package com.algorithms;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> last = new HashMap<>();
            int left = 0, maxLen = 0;

            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                if (last.containsKey(c) && last.get(c) >= left) left = last.get(c) + 1;
                last.put(c, right);
                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }
    }
