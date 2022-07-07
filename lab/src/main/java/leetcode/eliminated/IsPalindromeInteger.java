package leetcode.eliminated;

/**
 * @date :  20.11.3  18:36
 */
public class IsPalindromeInteger {
    public static void main(String[] args) {
        System.out.println(isPalindrome(21345312));

    }

    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        int l = 0;
        int y = x;
        while (y > 10) {
            l++;
            y /= 10;
        }
        if (l % 2 == 0) {
            int d = (int) Math.pow(10, l);
            while (x / d == x % 10) {
                l -= 2;
                if (l <= 0) return true;
                x = (x - x / d * d - x % 10) / 10;
                d = (int) Math.pow(10, l);
            }
            return false;
        } else {
            int d = (int) Math.pow(10, l);
            while (x / d == x % 10) {
                l -= 2;
                if (l <= 0) return true;
                x = (x - x / d * d - x % 10) / 10;
                d = (int) Math.pow(10, l);
            }
            return false;
        }
    }
}
