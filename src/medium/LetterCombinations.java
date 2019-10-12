package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    Map<Character, String> chars;

    LetterCombinations() {
        chars = new HashMap<>();
        chars.put('2', "abc");
        chars.put('3', "def");
        chars.put('4', "ghi");
        chars.put('5', "jkl");
        chars.put('6', "mno");
        chars.put('7', "pqrs");
        chars.put('8', "tuv");
        chars.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int j = digits.length() - 1; j >= 0; j--) {
            char ch = digits.charAt(j);
            if (!chars.containsKey(ch)) {
                return new ArrayList<String>();
            }
            result = permute(chars.get(ch), result);
        }
        return result;
    }

    List<String> permute(String str, List<String> result) {
        List<String> output = new ArrayList<>();
        if (result.size() == 0) {
            for (Character ch : str.toCharArray()) {
                output.add(ch.toString());
            }
            return output;
        }

        for (Character ch : str.toCharArray()) {
            for (String s : result) {
                output.add(ch + s);
            }
        }

        return output;
    }
}
