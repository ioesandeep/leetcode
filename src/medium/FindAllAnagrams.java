package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String str = s.substring(i, p.length() + i);
            if (isAnagram(str, p)) {
                indices.add(i);
            }
        }
        return indices;
    }

    boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
