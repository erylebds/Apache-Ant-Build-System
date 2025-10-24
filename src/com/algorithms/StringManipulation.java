package com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringManipulation {

    class ExcelSheetColumnTitle {
        public String convertToTitle(int columnNumber) {
            String result = "";

            while (columnNumber > 0) {
                columnNumber--;
                char c = (char) ('A' + (columnNumber % 26));
                result = c + result;
                columnNumber /= 26;
            }

            return result;
        }
    }

    class LengthOfLastWord {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            int lastSpaceIndex = s.lastIndexOf(' ');
            return s.length() - lastSpaceIndex - 1;
        }
    }

    class LongestCommonPrefix {
        public String longestCommonPrefix(String[] strs) {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (!strs[i].startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }

    }

    class LongestSubstringWithoutRepeatingCharacters {
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

    class RestoreIpAddresses {

        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), s, 0);
            return result;
        }

        private void backtrack(List<String> result, List<String> path, String s, int index) {
            if (path.size() == 4) {
                if (index == s.length()) {
                    result.add(String.join(".", path));
                }
                return;
            }

            for (int len = 1; len <= 3; len++) {
                if (index + len > s.length()) break;

                String part = s.substring(index, index + len);

                if (isValid(part)) {
                    path.add(part);
                    backtrack(result, path, s, index + len);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isValid(String part) {
            if (part.length() > 1 && part.charAt(0) == '0') return false;
            int num = Integer.parseInt(part);
            return num >= 0 && num <= 255;
        }
    }

    class ValidAnagram {
        public boolean isAnagram(String s, String t) {
            if ( s.length() != t.length() ) return false;

            Map<Character, Integer> anagram = new HashMap<>();

            for (char c : s.toCharArray()) {
                int x = anagram.getOrDefault( c , 0);
                anagram.put( c , x + 1);
            }
            for (char c : t.toCharArray()) {
                if (!anagram.containsKey(c)) return false;
                int newVal = anagram.get(c) - 1;
                if  (newVal < 0) return false;
                anagram.put(c, newVal);
            }
            return true;
        }
    }
}
