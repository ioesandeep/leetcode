package leetcode.easy;

public class ReverseVowelsString {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                left = i;
                right = replaceVowel(left, right, chars);
            }
        }
        return new String(chars);
    }

    int replaceVowel(int left, int right, char[] chars) {
        for (int j = right - 1; j > left; j--) {
            if (isVowel(chars[j])) {
                char ch = chars[left];
                chars[left] = chars[j];
                chars[j] = ch;
                return j;
            }
        }
        return 0;
    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
