package leetCode;

import org.junit.Test;

public class Test0008 {

    @Test
    public void test01() {
        char i = '9';
        String s = "-2147483649";
        int i1 = myAtoi(s);
        System.out.println(i1);
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int atoi = 0;
        String trim = str.trim();
        boolean falg = true;
        char[] charArray = trim.toCharArray();
        if (charArray[0] == '-') {
            falg = false;
        } else if (charArray[0] == '+') {
            falg = true;
        } else if (charArray[0] >= 48 && charArray[0] <= 57) {
            atoi = charArray[0] - 48;
        } else {
            return 0;
        }
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] >= 48 && charArray[i] <= 57) {
                int temp = charArray[i] - 48;
                if (atoi > Integer.MAX_VALUE / 10 || (atoi == Integer.MAX_VALUE / 10 && temp > 7)) {
                    return Integer.MAX_VALUE;
                } else if (atoi < Integer.MIN_VALUE / 10 || (atoi == Integer.MIN_VALUE / 10 && temp > 8)) {
                    return Integer.MIN_VALUE;
                }
                if (!falg) {
                    atoi = atoi * 10 - temp;
                } else {
                    atoi = atoi * 10 + temp;
                }
            } else {
                break;
            }
        }
        return atoi;
    }
}
