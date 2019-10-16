package easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        return charA.length >= charB.length ? addBinary(charA, charB) : addBinary(charB, charA);
    }

    String addBinary(char[] a, char[] b) {
        int carry = 0;
        StringBuilder sum = new StringBuilder();

        int j = b.length;
        for (int i = a.length - 1; i >= 0; i--) {
            int val = (a[i] - '0') + carry;
            if (j > 0) {
                val += (b[--j] - '0');
            }

            carry = val / 2;
            val = val % 2;

            sum.append(val);
        }

        if (carry == 1) {
            sum.append(1);
        }

        return sum.reverse().toString();
    }
}
