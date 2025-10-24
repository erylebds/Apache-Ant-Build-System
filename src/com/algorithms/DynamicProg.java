package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class DynamicProg {
    class DungeonGame {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;

            int[][] dp = new int[m][n];

            dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

            for (int i = m - 2; i >= 0; i--) {
                dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
            }

            for (int j = n - 2; j >= 0; j--) {
                dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
            }

            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    int minHealthFromNextCell = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, minHealthFromNextCell - dungeon[i][j]);
                }
            }
            return dp[0][0];
        }
    }

    class FizzBuzz {
        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>();

            for (int i=1; i <= n; i++){
                if (i % 3 == 0 && i % 5 == 0){
                    result.add("FizzBuzz");
                }else if(i%3==0){
                    result.add("Fizz");
                }else if(i%5==0){
                    result.add("Buzz");
                }else{
                    result.add(String.valueOf(i));
                }
            }
            return result;
        }
    }

    class HouseRobber {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }

            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[n - 1];
        }
    }

}
