package space.kuzznya.leetcode.task139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
//                System.out.println(j + " " + i + " " + s.substring(j, i));
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
