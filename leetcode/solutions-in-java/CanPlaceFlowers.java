/*
    605. Can Place Flowers

    You have a long flowerbed in which some of the plots are planted, and some are not.
    However, flowers cannot be planted in adjacent plots.
    Given an integer array flowerbed containing 0's and 1's,
    where 0 means empty and 1 means not empty, and an integer n,
    return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 */

public class CanPlaceFlowers {
    public static void main(String[] args) {
        var flowerbed = new int[]{1, 0, 1, 0, 1};
        var n = 1;
        System.out.println(validate(flowerbed, n));
    }

    private static boolean validate(int[] flowerbed, int n) {
        var counter = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i]++;
                counter++;
            }
        }
        return counter >= n;
    }
}
