package space.kuzznya.leetcode.task76;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> requirements = new HashMap<>();
        for (char c : t.toCharArray()) {
            requirements.put(c, requirements.getOrDefault(c, 0) + 1);
        }
        int totalRequirements = requirements.size();

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int requirementsMet = 0;
        int minWindowLength = Integer.MAX_VALUE;
        String result = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            if (requirements.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == requirements.get(c).intValue()) requirementsMet++;
            }
            if (requirementsMet == totalRequirements) {
                while (left <= right && requirementsMet == totalRequirements) {
                    if (right - left + 1 < minWindowLength) {
                        minWindowLength = right - left + 1;
                        result = s.substring(left, right + 1);
                    }

                    if (requirements.containsKey(s.charAt(left))) {
                        window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                        if (window.get(s.charAt(left)) < requirements.get(s.charAt(left))) requirementsMet--;
                    }

                    left++;
                }
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowSubstring.minWindow("a", "a"));
    }
}
