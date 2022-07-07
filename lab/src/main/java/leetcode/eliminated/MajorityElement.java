package leetcode.eliminated;

import java.util.Arrays;

/**
 * @date :  19.4.9  16:03
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 5, 2, 6, 2, 2, 3, 2, 4, 2, 2, 2, 2, 2, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }

    /**
     * @ https://leetcode-cn.com/problems/majority-element/comments/
     */

    private static int majorityElement(int[] nums) {
        int index = nums[0];
        int count = 1;
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] == index) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    index = nums[i];
                    count = 1;
                }
            }
        }
        return index;
    }

    private static int majorityElement2(int[] nums) {  //todo not best
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
