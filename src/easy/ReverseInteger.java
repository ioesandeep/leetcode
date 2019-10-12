package easy;

public class ReverseInteger {
    public int reverse(int num) {
        long revnum = 0;
        while (num != 0) {
            revnum = revnum * 10 + (num % 10);
            if (revnum >= Integer.MAX_VALUE || revnum <= Integer.MIN_VALUE) {
                return 0;
            }
            num /= 10;
        }
        return (int) revnum;
    }
}
