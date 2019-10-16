package leetcode.medium;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return true;
        }

        if (s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }

        int[] s1Chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Chars[s1.charAt(i) - 'a']++;
        }

        int[] result = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            if (isPermutation(result, s1Chars)) {
                return true;
            }

            result[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) {
                result[s2.charAt(i - s1.length()) - 'a']--;
            }
        }

        return isPermutation(result, s1Chars);
    }

    boolean isPermutation(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}
