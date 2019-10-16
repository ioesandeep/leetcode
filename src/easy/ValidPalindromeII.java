package easy;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (isPal(s, left, right)) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                //delete from left
                if (isPal(s, left + 1, right)) {
                    return true;
                }

                //or delete from right
                if (isPal(s, left, right - 1)) {
                    return true;
                }

                return false;
            }
            left++;
            right--;
        }
        return false;
    }

    boolean isPal(String s, int left, int right) {
        while (left < s.length() && right >= 0 && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}
