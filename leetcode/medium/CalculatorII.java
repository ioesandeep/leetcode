package leetcode.medium;

public class CalculatorII {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int[] nums = new int[s.length()];
        int num = 0;
        int j = 0;
        //default operation
        char c = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
                //continue only if we have not reached the end
                if (i < s.length() - 1) {
                    continue;
                }
            }
            if (c == '+') {
                nums[j++] = num;
            }
            if (c == '-') {
                nums[j++] = num * -1;
            }
            if (c == '*') {
                nums[j - 1] *= num;
            }
            if (c == '/') {
                nums[j - 1] /= num;
            }
            num = 0;
            c = ch;
        }

        //sum all numbers
        int sum = 0;
        for (int i = 0; i < j; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
