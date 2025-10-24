package com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class StackProblems {
    class ValidParenthesis {
        public boolean isValid(String s) {
            HashMap<Character, Character> vpChecker = new HashMap<>() {{
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }};

            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (vpChecker.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || vpChecker.get(stack.pop()) != c)
                        return false;
                }
            }
            return stack.isEmpty();
        }
    }

    class PalindromePartitioning {

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
}
