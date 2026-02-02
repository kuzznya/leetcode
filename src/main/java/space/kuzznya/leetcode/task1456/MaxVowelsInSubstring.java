package space.kuzznya.leetcode.task1456;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowelsInSubstring {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int left = 0;
        int right = 0;
        int maxVowels = 0;
        int curVowels = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (vowels.contains(c)) {
                curVowels++;
                maxVowels = Math.max(maxVowels, curVowels);
            }
            right++;
            if (right - left >= k) {
                char d = s.charAt(left);
                if (vowels.contains(d)) {
                    curVowels--;
                }
                left++;
            }
        }
        return maxVowels;
    }

    public static void main(String[] args) {
        MaxVowelsInSubstring maxVowelsInSubstring = new MaxVowelsInSubstring();
        System.out.println(maxVowelsInSubstring.maxVowels("leetcode", 3));
    }
}
