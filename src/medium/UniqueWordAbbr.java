package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbr {
    Map<String, Set<String>> map;

    public UniqueWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = abbr(word);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<>());
            }
            Set<String> set = map.get(abbr);
            set.add(word);
        }
    }

    String abbr(String word) {
        if (word.length() <= 2) {
            return word;
        }

        return word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
    }

    public boolean isUnique(String word) {
        String abbr = abbr(word);
        if (!map.containsKey(abbr)) {
            return true;
        }

        Set<String> set = map.get(abbr);
        if (set.size() > 1) {
            return false;
        }

        return set.contains(word);
    }
}
