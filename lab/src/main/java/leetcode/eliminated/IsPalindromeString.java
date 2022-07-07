package leetcode.eliminated;

/**
 * @date :  19.4.10  16:32
 */
public class IsPalindromeString {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * https://leetcode-cn.com/problems/valid-palindrome/
     */
    private static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        char[] re = new StringBuilder(s).reverse().toString().toCharArray();
        int length = arr.length;
        for (int i = 0, j = 0; i <= arr.length - 1; ) {
            if (!(arr[i] >= '0' && arr[i] <= '9' || arr[i] >= 'A' && arr[i] <= 'Z' || arr[i] >= 'a' && arr[i] <= 'z') || arr[i] == ' ') {
                i++;
                continue;
            }// fixme without R阁下
            if (!(re[j] >= '0' && re[j] <= '9' || re[j] >= 'A' && re[j] <= 'Z' || re[j] >= 'a' && re[j] <= 'z') || re[j] == ' ') {
                j++;

                continue;
            }
            if (arr[i] == re[j] || Character.toString(arr[i]).equalsIgnoreCase(Character.toString(re[j]))) {
                i++;
                j++;
                if (i > length || j > length) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
