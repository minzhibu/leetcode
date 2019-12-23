package leetCode;

import org.junit.Test;

public class Test0048 {
    /**
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * [5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]
     */
    @Test
    public void test0048() {
        int[][] nums = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        rotate(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int k = 0; k < matrix.length - 1; k++) {
            int num1 = 0;
            int num2 = matrix.length - 1 - (2 * k);
            for (int i = k; i < matrix.length - 1 - k; i++) {
                int tmp = 0;
                int x = k;
                int y = i;
                tmp = matrix[x][y];
                for (int j = 0; j <= 3; j++) {
                    x += num1;
                    y += num2;
                    temp = matrix[x][y];
                    matrix[x][y] = tmp;
                    tmp = temp;
                    temp = num2;
                    num2 = num1;
                    num1 = temp;
                    num2 = 0 - num2;
                }
                ++num1;
                --num2;
            }
        }
    }

}
