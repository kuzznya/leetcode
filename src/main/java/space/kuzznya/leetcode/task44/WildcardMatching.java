package space.kuzznya.leetcode.task44;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                if (j > 0 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || i > 0 && dp[i - 1][j];
                }
                else if (j > 0 && p.charAt(j - 1) == '?') {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1];
                }
                else if (i > 0 && j > 0 && s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] ? "1 " : "0 ");
//            }
//            System.out.println();
//        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("aa", "a"));
        System.out.println(wildcardMatching.isMatch("aa", "*"));
        System.out.println(wildcardMatching.isMatch("cb", "?a"));
        System.out.println(wildcardMatching.isMatch("adceb", "*a*b"));
        System.out.println(wildcardMatching.isMatch("acdcb", "a*c?b"));
    }
}
