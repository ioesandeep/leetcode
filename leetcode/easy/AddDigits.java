package leetcode.easy;

public class AddDigits {
    public int addDigits(int num) {
        int sum = findSum(num);
        return sum < 10 ? sum : addDigits(sum);
    }

    int findSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
