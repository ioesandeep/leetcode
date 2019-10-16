package medium;

public class StringToInt {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        //cleanup whitespaces
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            }
            str = str.substring(i);
            break;
        }

        if (str.length() == 0) {
            return 0;
        }

        char first = str.charAt(0);
        //not valid if the first character is not numeric or a plus/minus sign
        if ((first < 48 || first > 57) && first != '+' && first != '-') {
            return 0;
        }

        int multiplier = 1;
        long value = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-') {
                if (multiplier == 1 && i == 0) {
                    multiplier = ch == '+' ? 1 : -1;
                    continue;
                }
                break;
            }

            if (ch < 48 || ch > 57) {
                break;
            }
            value = value * 10 + (ch - '0');
            if (value > Integer.MAX_VALUE) {
                return multiplier == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        value *= multiplier;

        return (int) value;
    }
}
