package space.kuzznya.leetcode.task140;

import java.util.*;

public class WordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[s.length() + 1][wordDict.size()];
        Arrays.fill(dp[0], true);
        boolean[] possible = new boolean[s.length() + 1];
        possible[0] = true;

        int pos = 0;
        while (pos <= s.length()) {
            for (int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                int prevPos = pos - word.length();
                if (prevPos < 0 || !possible[prevPos] || !s.substring(prevPos, pos).equals(word)) continue;

                dp[pos][i] = true;
                possible[pos] = true;
            }
            pos++;
        }

        if (!possible[s.length()]) return Collections.emptyList();

        List<String> results = new ArrayList<>();
        collectResults(dp, wordDict, "", dp.length - 1, results);

        return results;
    }

    private void collectResults(boolean[][] dp, List<String> wordDict, String suffix, int pos, List<String> results) {
        if (pos == 0) {
            results.add(suffix);
            return;
        }
        for (int i = 0; i < dp[pos].length; i++) {
            String word = wordDict.get(i);
            int prevPos = pos - word.length();
            if (dp[pos][i] && prevPos >= 0) {
                String nextSuffix = !suffix.isEmpty() ? word + " " + suffix : word;
                collectResults(dp, wordDict, nextSuffix, pos - word.length(), results);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakTwo wordBreakTwo = new WordBreakTwo();
//        System.out.println(wordBreakTwo.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreakTwo.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }
}
