package medium;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int sizeOfResult = num1.length() + num2.length();
        int[] result = new int[sizeOfResult];

        int carry = 0;
        int pointer = result.length - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int start = pointer;
            carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int res = n1 * n2 + result[start] + carry;
                carry = res / 10;
                res %= 10;
                result[start] = res;
                start--;
            }
            if (carry > 0) {
                result[start] = carry;
            }
            pointer--;
        }

        if (carry > 0) {
            result[0] = carry;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[0] == 0) {
                continue;
            }
            builder.append(result[i]);
        }

        return builder.toString();
    }
}
