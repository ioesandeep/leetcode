package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ImplementMagicDictionary {
    /**
     * Initialize your data structure here.
     */
    List<String> list;

    public ImplementMagicDictionary() {
        list = new ArrayList<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            list.add(str);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        for (String str : list) {
            if (oneEditAway(str, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean oneEditAway(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        boolean isReplaced = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (isReplaced) {
                    return false;
                }
                isReplaced = true;
            }

        }
        return isReplaced;
    }
}
