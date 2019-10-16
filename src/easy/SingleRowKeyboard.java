package easy;

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        if (word.length() == 0) {
            return 0;
        }

        int[] chars = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            int ch = keyboard.charAt(i) - 'a';
            chars[ch] = i;
        }

        char prev = word.charAt(0);
        int moves = chars[prev - 'a'];

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            moves += Math.abs(chars[prev - 'a'] - chars[current - 'a']);
            prev = current;
        }

        return moves;
    }
}
