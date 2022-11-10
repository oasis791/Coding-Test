public class Programmers_Long_Jump {
    static class Solution {
        public static long solution(int n) {
            int[] dp = new int[n + 1];
            if(n==1) return 1;
            if(n==2) return 2;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 2] % 1234567 + dp[i - 1] % 1234567) % 1234567;
            }
            return dp[n];
        }
    }
}
