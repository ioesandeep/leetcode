package leetcode.medium;

public class IntegerToRoman {
    StringBuilder builder;

    String intToRoman(int num) {
        builder = new StringBuilder();
        romanHelper(num);
        return builder.toString();
    }

    void romanHelper(int num) {
        if (num == 0) {
            return;
        }

        int length = String.valueOf(num).length();
        int divider = getDivider(num, length);
        int count = num / divider;
        int rem = num % divider;

        if (divider == 1000) {
            appendString(count, divider);
            romanHelper(rem);
            return;
        }

        if (divider == 500) {
            if (rem >= 400) {
                builder.append('C');
                builder.append('M');
                rem %= 100;
            } else {
                appendString(count, divider);
            }

            romanHelper(rem);
            return;
        }

        if (divider == 100) {
            if (count >= 4) {
                builder.append('C');
                builder.append('D');
            } else {
                appendString(count, divider);
            }
            romanHelper(rem);
            return;
        }

        if (divider == 50) {
            if (rem >= 40) {
                builder.append('X');
                builder.append('C');
                rem %= 10;
            } else {
                appendString(count, divider);
            }
            romanHelper(rem);
            return;
        }

        if (divider == 10) {
            if (count >= 4) {
                builder.append('X');
                builder.append('L');
            } else {
                appendString(count, divider);
            }
            romanHelper(rem);
            return;
        }

        if (divider == 5) {
            if (rem >= 4) {
                builder.append('I');
                builder.append('X');
                rem = 0;
            } else {
                appendString(count, divider);
            }

            romanHelper(rem);
            return;
        }

        //base case
        if (rem < 3) {
            if (num == 4) {
                builder.append('I');
                builder.append('V');
            } else {
                appendString(num, divider);
            }
            return;
        }
    }

    void appendString(int count, int divider) {
        for (int i = 1; i <= count; i++) {
            builder.append(dividerToChar(divider));
        }
    }

    Character dividerToChar(int divider) {
        if (divider == 1000) {
            return 'M';
        }

        if (divider == 500) {
            return 'D';
        }

        if (divider == 100) {
            return 'C';
        }

        if (divider == 50) {
            return 'L';
        }

        if (divider == 10) {
            return 'X';
        }

        return divider == 5 ? 'V' : 'I';
    }

    int getDivider(int num, int length) {
        if (length == 4) {
            return 1000;
        }

        if (length == 3) {
            return num >= 500 ? 500 : 100;
        }

        if (length == 2) {
            return num >= 50 ? 50 : 10;
        }

        return num >= 5 ? 5 : 3;
    }

}
