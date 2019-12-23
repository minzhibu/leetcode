package leetCode;

import org.junit.Test;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 */
public class Test0029 {

    @Test
    public void test0029() {
        int divide = divide(Integer.MIN_VALUE, -1);
        System.out.println(Integer.MIN_VALUE / -1);
        System.out.println(divide);
    }

    public int divide(int dividend, int divisor) {
        int num = 0;
        long sum = 0;
        long dividend1 = 0;
        int divisor1 = 0;
        if(dividend == divisor){
            return 1;
        }
        if (dividend == Integer.MIN_VALUE) {
            dividend1 = Integer.MAX_VALUE + 1;
        } else {
            dividend1 = dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        dividend1 = Math.abs(dividend1);
        divisor1 = Math.abs(divisor);
        int temp = 0;
        int tempNum = 0;
        while ((sum - temp) < dividend1) {
            if ((sum + temp) > dividend1) {
                if ((sum - divisor1 + temp) > dividend1) {
                    sum -= temp;
                    num -= tempNum;
                }
                if ((sum + divisor1) > dividend1) {
                    break;
                }
                temp = 0;
                tempNum = 0;
            }
            if (temp == 0) {
                temp = divisor1;
            } else {
                temp += temp;
            }
            sum += temp;
            if (tempNum == 0) {
                ++tempNum;
            } else {
                tempNum += tempNum;
            }
            num += tempNum;
        }
        while ((sum + divisor1) < dividend1) {
            sum += divisor1;
            ++num;
            if (sum == dividend1) {
                break;
            }
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return 0 - num;
        }
        return num == Integer.MIN_VALUE ? Integer.MAX_VALUE : num;
    }
}
