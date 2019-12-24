package leetCode;

import org.junit.Test;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Test0050 {

    @Test
    public void test0050(){
        double v = myPow(2.00000, 10);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1/x;
        }
        double half = myPow(x,n/2);
        double rest = myPow(x,n%2);
        return rest * half * half;

    }
}
