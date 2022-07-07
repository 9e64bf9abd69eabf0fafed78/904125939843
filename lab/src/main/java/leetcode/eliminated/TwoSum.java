package leetcode.eliminated;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date :  19.3.5  11:13
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
//        int[] nums = { 2 , 7 , 11 , 15 };
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    /**
     * https://leetcode-cn.com/problems/two-sum/two-sum
     */
    private static int[] twoSum(int[] nums, int target) {
        //todo   1. 取到每个数, 向后遍历相加, 和与target相等时返回两个数的角标 ;    → O(n*n) / O(1)
        //todo   2. 空间换时间: 借助hash表的快速查找 ;                                                                → O(n) / O(n)
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        /*for ( int i : map.keySet() ) {    //fixme  如果遍历map  则 当nums={1,1} , target=2时会无结果,  故不可取.
            int otherHalf = target - i;*/
        for (int i = 0; i < length; i++) {
            int otherHalf = target - nums[i];
            if (map.containsKey(otherHalf) && map.get(otherHalf) != i) {
                return new int[]{i, map.get(otherHalf)};
            }
        }
        return new int[]{-1, -1};
    }
}
