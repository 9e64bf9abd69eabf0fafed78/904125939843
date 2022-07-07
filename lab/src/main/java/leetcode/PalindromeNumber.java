package leetcode;

/**
 * @date :  19.3.5  16:16
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1000021));
//        System.out.println( getCount( 123001 ) );
//        System.out.println( ( int ) ( Math.pow( 10 , getCount( 232 ) - 1 ) ) );
    }

    static private boolean isPalindrome(int x) {
        if (x < 0 || x >= Integer.MAX_VALUE) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int tail = x % 10;
        int count = getCount(x);
        int head = x / ((int) (Math.pow(10, count - 1)));
        if (tail == head) {
            isPalindrome(x % ((int) (Math.pow(10, count - 1))) - tail);
        } else {
            return false;
        }
        return true;
    }

    private static int getCount(int num) {
        int count = 1;
        while (num >= 10) {
            num = (num - num % 10) / 10;
            count++;
        }
        return count;
    }
}
