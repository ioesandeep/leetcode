package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class KLengthSubstringNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length() - K + 1; i++) {
            String str = S.substring(i, i + K);
            if (map.containsKey(str) && map.get(str) == 0) {
                continue;
            }

            map.put(str, map.getOrDefault(str, 0) + (isUnique(str) ? 1 : 0));
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            count += entry.getValue();
        }

        return count;
    }

    boolean isUnique(String str) {
        int[] chars = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (chars[ch] > 0) {
                return false;
            }
            chars[ch]++;
        }

        return true;
    }
}
