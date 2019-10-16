package easy;

public class GuessNumberHigherOrLower {
    //method available through API
    int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        return guessHelper(1, n);
    }

    int guessHelper(int from, int to) {
        int mid = from + (to - from) / 2;
        int guess = guess(mid);
        if (guess == 0) {
            return mid;
        }
        return guess < 0 ? guessHelper(from, mid - 1) : guessHelper(mid + 1, to);
    }
}
