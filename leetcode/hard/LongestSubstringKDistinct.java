package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int slidePos = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                char c = s.charAt(slidePos);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                slidePos++;
            }

            max = Math.max(max, i - slidePos + 1);
        }

        return max;
    }
}
