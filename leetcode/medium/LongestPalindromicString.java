package leetcode.medium;

public class LongestPalindromicString {
    public String longestPalindrome(String s) {
        int size = s.length();
        String largest = "";
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                boolean isPal = isPalindrome(sub);
                if (isPal && sub.length() >= largest.length()) {
                    largest = sub;
                }
            }
        }
        return largest;
    }

    boolean isPalindrome(String s) {
        int size = s.length();
        int mid = size / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
