package leetCode;

import org.junit.Test;

public class Test0059 {


    @Test
    public void test0059(){
        int[][] ints = generateMatrix(2);
        for(int i = 0; i < ints.length;i++){
            for(int j = 0; j < ints[i].length;j++){
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }

    }
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        // 1.循环n+1/2次 定义为i
        int index = 0;
        for(int i = 0 ; i < (n+1)/2 ; i++){
            // 2.上面一排从i开始写入数字，i作为二维数组的行，定义一个j = i，每次循环到n-i-1为止
            for(int j = i ;j < n-i;j++){
                nums[i][j] = ++index;
            }
            // 3.右边一排 列为[n-i-1]，行为[i+1]开始到n-i-1为止
            for(int j = i + 1 ; j < n - i; j++){
                nums[j][n-i-1] = ++index;
            }
            // 4.下面这排 行为[n-i-1], 列从[n-i-2]开始--到0为止
            for(int j = n-i-2 ; j >= i ;j--){
                nums[n-i-1][j] = ++index;
            }
            // 5.左边一排 列为i 行为[n-i-2]开始--到0为止
            for(int j = n-i-2 ; j > i ;j--){
                nums[j][i] = ++index;
            }
        }
        return nums;
    }
}
