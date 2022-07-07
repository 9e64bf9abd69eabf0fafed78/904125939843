package leetcode.eliminated;

/**
 * @date :  19.4.8  14:49
 */
public class SingleInteger {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
//        int[] arr = { 1 , 2 , 3 , 4 , 5 , 3 , 1 , 2 , 4 };
        System.out.println(getSingleInteger(arr));
    }

    /**
     * https://leetcode-cn.com/problems/single-number/
     */
    private static int getSingleInteger(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            result = result ^ nums[i + 1];
        }
        return result;
    }
}
