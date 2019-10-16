package easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            char left = str.charAt(i);
            if ((left < 97 || left > 122) && (left < 48 || left > 57)) {
                i++;
                continue;
            }

            char right = str.charAt(j);
            if ((right < 97 || right > 122) && (right < 48 || right > 57)) {
                j--;
                continue;
            }
            if (left == right) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}
