package array;

public class SumDigitsMinimumNumber {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
        }

        if (min == 0) {
            return 0;
        }

        return getSum(min) % 2 == 1 ? 0 : 1;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
