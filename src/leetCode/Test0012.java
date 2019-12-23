package leetCode;

import org.junit.Test;

public class Test0012 {

    @Test
    public void test01() {
        String s = intToRoman(1994);
        System.out.println(s);
    }

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                builder.append(roman[i]);
                num -= nums[i];
            }
        }
        return builder.toString();
    }
}
