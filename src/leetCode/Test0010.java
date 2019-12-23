package leetCode;

import org.junit.Test;

public class Test0010 {

    @Test
    public void test01() {
        boolean aa = isMatch("aaa", "ab*a*c*a");
        System.out.println(aa);
    }
    //未完成哎

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (".*".equals(p)) {
            return true;
        }
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        int charPIndex = 0;
        int charSIndex = 0;
        while (charPIndex < charP.length && charSIndex < charS.length) {
            if (charP[charPIndex] == '.') {
                charPIndex++;
                charSIndex++;
            } else if (charP[charPIndex] == '*') {
                if (charP[charPIndex - 1] == '.') {
                    charSIndex++;
                } else if (charP[charPIndex - 1] == charS[charSIndex]) {
                    charSIndex++;
                    if (charSIndex == charS.length) {
                        while (charPIndex < charP.length) {
                            if(charP[charPIndex]=='*'||charP[charPIndex]==charS[charSIndex-1]) {
                                charPIndex++;
                            }else {
                                return false;
                            }
                        }
                    }
                } else {
                    charPIndex++;
                }
            } else if (charP[charPIndex] == charS[charSIndex]) {
                charPIndex++;
                charSIndex++;
            } else {
                if (charP[charPIndex + 1] == '*') {
                    charPIndex += 2;
                } else {
                    return false;
                }
            }
        }
        return charSIndex == charS.length && charPIndex == charP.length;
    }
}
