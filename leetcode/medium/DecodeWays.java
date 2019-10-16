package leetcode.medium;

public class DecodeWays {
    public int numDecodings(String str) {
        if (str.length() == 0 || str.charAt(0) == '0') {
            return 0;
        }

        //it follows a fibonacci sequence in ideal conditions
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= str.length(); i++) {
            String s = str.substring(i - 2, i);
            //if the last character in the subsequence is 0
            if (s.charAt(1) == '0') {
                //if the first character is 0 as well
                //or the integer value of subsequence is 0
                //return 0 (not a valid string)
                if (s.charAt(0) <= '0' || Integer.valueOf(s) > 26) {
                    return 0;
                }
                dp[i] = dp[i - 2];
                continue;
            }
            //if the first character in the subsequence is 0
            //or the integer value of subsequence is greate than 26
            if (s.charAt(0) == '0' || Integer.valueOf(s) > 26) {
                dp[i] = dp[i - 1];
                continue;
            }
            //follow the fibonacci sequence
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[str.length()];
    }
}
