package math;

public class ArmstrongNumber {
    public boolean isArmstrong(int N) {
        int size = N == 0 ? 1 : (int) (Math.log10(N)) + 1;
        int sum = 0;
        int n = N;
        while (n != 0) {
            sum += Math.pow(n % 10, size);
            n /= 10;
        }
        return sum == N;
    }
}
