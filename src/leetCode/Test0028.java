package leetCode;

import org.junit.Test;

public class Test0028 {

    @Test
    public void test0028() {
        int i = strStr("mississippi",
                "issi");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        haystack.indexOf(needle);
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
        while (i < hChars.length && j < nChars.length) {
            if (j == -1 || hChars[i] == nChars[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
            if (j == next.length) {
                return i - j;
            }
        }
        return -1;
    }

    private int[] getNext(String needle) {
        char[] needleChar = needle.toCharArray();
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < next.length - 1) {
            if (j == -1 || needleChar[i] == needleChar[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

//    private int[] getNext(String pattern) {
//        char[] p = pattern.toCharArray();
//        int[] next = new int[p.length];
//        // 第一位设为-1，方便判断当前位置是否为搜索词的最开始
//        next[0] = -1;
//        int i = 0;
//        int j = -1;
//
//        while(i < p.length - 1) {
//            if (j == -1 || p[i] == p[j]) {
//                i++;
//                j++;
//                next[i] = j;
//            } else {
//                j = next[j];
//            }
//        }
//
//        return next;
//    }

}
