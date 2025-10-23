package com.algorithms;
import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

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


