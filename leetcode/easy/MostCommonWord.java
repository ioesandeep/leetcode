package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(clean(word));
        }

        String[] words = paragraph.toLowerCase().split("[^a-z0-9]");
        Map<String, Integer> counts = new HashMap<>();
        String maxWord = null;
        int count = 0;
        for (String word : words) {
            String str = clean(word);
            if (str.equals("") || bannedSet.contains(str)) {
                continue;
            }
            int c = counts.getOrDefault(str, 0);
            counts.put(str, c + 1);
            if (c + 1 > count) {
                count = c + 1;
                maxWord = str;
            }

        }
        return maxWord;
    }

    private String clean(String word) {
        return word.toLowerCase().replaceAll("[^a-z]", "");
    }
}
