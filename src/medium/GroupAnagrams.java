package medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String anagram = buildAnagram(str);
            if (!result.containsKey(anagram)) {
                result.put(anagram, new ArrayList<>());
            }
            result.get(anagram).add(str);
        }

        return new ArrayList<>(result.values());
    }

    String buildAnagram(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.copyValueOf(chars);
    }
}
