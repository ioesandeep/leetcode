package leetcode.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int end = s.length() - 1;
        int start = end;
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        for (int i = start; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                break;
            }
            ++length;
        }

        return length;
    }
}
