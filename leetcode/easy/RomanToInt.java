package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                if (map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
                    continue;
                }
            }
            if (i > 0) {
                if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                    sum -= map.get(s.charAt(i - 1));
                }
            }
            sum += map.get(s.charAt(i));
        }
        return sum;
    }
}
