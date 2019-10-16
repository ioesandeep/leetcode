package easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (carry == 0) {
                break;
            }
            int digit = digits[i];
            digit += carry;
            carry = digit / 10;
            digit = digit % 10;
            digits[i] = digit;
        }

        //ammortize the array
        if (carry == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                newArr[i + 1] = digits[i];
            }
            return newArr;
        }
        return digits;
    }
}
