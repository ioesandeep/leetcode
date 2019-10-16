package leetcode.easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }

        char first = word.charAt(0);
        if (first >= 'a' && first <= 'z') {
            return verifyRange(word, 1, 'a', 'z');
        }
        char second = word.charAt(1);
        return second >= 'a' && second <= 'z' ? verifyRange(word, 2, 'a', 'z') : verifyRange(word, 2, 'A', 'Z');
    }

    boolean verifyRange(String word, int pos, char start, char end) {
        if (pos >= word.length()) {
            return true;
        }
        char ch = word.charAt(pos);
        if (ch < start || ch > end) {
            return false;
        }
        return verifyRange(word, pos + 1, start, end);
    }
}
