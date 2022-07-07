package leetcode.eliminated;

/**
 * @date :  19.4.9  17:13
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
        };
/*
        int[][] matrix = {
                { 1 , 4 , 7 , 11 , 15 } ,
                { 2 , 5 , 8 , 12 , 19 } ,
                { 3 , 6 , 9 , 16 , 22 } ,
                { 10 , 13 , 14 , 17 , 24 } ,
                { 18 , 21 , 23 , 26 , 30 } };
*/
        int target = 30;
        System.out.println(searchMatrix(matrix, target));
    }

    /**
     * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     */

    private static boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) {
            return false;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return false;
        }
        int m = 0;
        int n = 1;
        int cursor = matrix[0][width - n];
        while (true) {
            if (cursor == target) {
                return true;
            }
            if (cursor < target) {
                m++;
            } else {
                n++;
            }
            if (m == height || n == width + 1) {
                return false;
            }
            cursor = matrix[m][width - n];
        }
    }
}
