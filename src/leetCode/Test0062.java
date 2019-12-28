package leetCode;

import org.junit.Test;

import java.util.Arrays;

public class Test0062 {


    @Test
    public void test0062(){
        int i = uniquePaths1(7, 3);
        System.out.println(i);
    }

    private int count;

    public int uniquePaths(int m, int n) {
        //第一步判断m或则n是否等于0，等于0返回0
        if (m == 0 || n == 0) {
            return 0;
        }
        //第二步判断m或则n是否等于1，等于1返回1
        if (m == 1 || n == 1) {
            return 1;
        }
        //第三步调用递归起始条件m-1,n-1
        helper(m-1,n-1);
        //第四步返回递归条件
        return count;
    }

    //递归函数
    public void helper(int m, int n) {
        //第一步判断m和n是否等于0等于0返回定义一个成员变量++
        if (m == 0 && n == 0) {
            count++;
        }
        //第二步判断m>0则调用自己，条件m-1,n
        if (m > 0) {
            helper(m - 1, n);
        }
        //第三步判断n>0则调用自己，条件m,n-1
        if (n > 0) {
            helper(m, n - 1);
        }
    }

    /**
     * 抄的代码，幸好搞懂原理了努力吧！
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];
    }





}
