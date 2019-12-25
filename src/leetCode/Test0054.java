package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test0054 {
    /**
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * [1,11],
     * [2,12],
     * [3,13],
     * [4,14],
     * [5,15],
     * [6,16],
     * [7,17],
     * [8,18],
     * [9,19],
     * [10,20]
     */
    @Test
    public void test0054() {
//        int[][] nums = new int[][]{{1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}, {6, 16}, {7, 17}, {8, 18}, {9, 19}, {10, 20}};
//        int[][] nums = new int[][]{{1, 2, 3, 4 },{5, 6, 7, 8},{9,10,11,12}};
        int[][] nums = new int[][]{{6},{7},{8}};
        System.out.println(nums.length);
        List<Integer> list = spiralOrder(nums);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int num = matrix.length % 2 == 0 ? matrix.length / 2 : matrix.length / 2 + 1;
        for (int i = 0; i < num; i++) {
            int j = i;
            int n = i;
            if (j == matrix[0].length - i) {
                break;
            }
            for (; j < matrix[0].length - i; j++) {
                list.add(matrix[n][j]);
            }
            n = n + 1;
            j--;
            if (n == matrix.length - i) {
                break;
            }
            for (; n < matrix.length - i; n++) {
                list.add(matrix[n][j]);
            }
            j--;
            n--;
            for (; j >= i; j--) {
                list.add(matrix[n][j]);
            }
            n--;
            j++;
            if (j == matrix[0].length - i - 1) {
                break;
            }
            for (; n > i; n--) {
                list.add(matrix[n][j]);
            }
        }
        return list;
    }
}
