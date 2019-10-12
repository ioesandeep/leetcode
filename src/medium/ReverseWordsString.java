package medium;

public class ReverseWordsString {
    StringBuilder builder;

    public String reverseWords(String s) {
        builder = new StringBuilder();
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                if (end == Integer.MIN_VALUE) {
                    end = i;
                }
                start = i;
                continue;
            }

            if (start <= end && end != Integer.MIN_VALUE) {
                appendWord(s, start, end);
                start = end = Integer.MIN_VALUE;
            }
        }

        if (start <= end && end != Integer.MIN_VALUE) {
            appendWord(s, start, end);
        }

        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    void appendWord(String str, int start, int end) {
        String sub = str.substring(start, end + 1);
        builder.append(sub);
        builder.append(' ');
    }
}
