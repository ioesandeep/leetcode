package leetcode.medium;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        int[] chars = new int[256];
        while (right < s.length()) {
            if (chars[s.charAt(right)] > 0) {
                //reset the slider (window)
                while (s.charAt(left) != s.charAt(right)) {
                    chars[s.charAt(left)]--;
                    left++;
                }
                chars[s.charAt(left)]--;
                left++;
            }
            chars[s.charAt(right)]++;
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }

}
