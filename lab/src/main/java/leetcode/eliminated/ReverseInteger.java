package leetcode.eliminated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date :  19.3.5  14:12
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(15342369));
    }

    /**
     * https://leetcode-cn.com/problems/reverse-integer/
     */

    private static int reverse(int x) {
        if (x == 0 || x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        int integer = (x < 0 ? -x : x);
        char[] chars = Integer.toString(integer).toCharArray();
        for (int i = chars.length - 1; i > -1; i--) {
            if (list.size() == 0 && chars[i] == '0') {
                continue;
            }
            list.add(chars[i]);
        }
        long l = Long.parseLong((x < 0 ? "-" : "") + Arrays.toString(list.toArray())
                .replaceAll("\\[", "").replaceAll("]", "")
                .replaceAll(",", "").replaceAll(" ", ""));
        if (l <= Integer.MIN_VALUE || l >= Integer.MAX_VALUE) {
            return 0;
        }
        return (int) l;
    }
}
