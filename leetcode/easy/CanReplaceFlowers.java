package leetcode.easy;

public class CanReplaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return n == 0;
        }

        if (flowerbed.length == 1) {
            return (flowerbed[0] == 0 && n == 1) || n == 0;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                break;
            }

            if (flowerbed[i] == 1) {
                continue;
            }

            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }

            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }
}
