package com.algorithms;
import java.util.ArrayList;
import java.util.List;
public class PalindromePartitioning {

        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), s, 0);
            return result;
        }

        private void backtrack(List<List<String>> result, List<String> path, String s, int start) {
            if (start == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (isPalindrome(substring)) {
                    path.add(substring);
                    backtrack(result, path, s, end);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String str) {
            int left = 0, right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }
    }


