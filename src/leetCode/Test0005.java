package leetCode;

import org.junit.Test;

public class Test0005 {

    @Test
    public void test(){
        String s = "baab";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = lenthOfPalindrome2(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }
    private int lenthOfPalindrome2(char[] str, int left, int[] range){
        int right = left;
        while (right < str.length - 1 && str[right + 1] == str[left]){
            right++;
        }
        int ans = right;
        while(left > 0 && right < str.length - 1 && str[left - 1] == str[right + 1]){
            left --;
            right ++;
        }
        if(right - left > range[1] - range[0]){
            range[0] = left;
            range[1] = right;
        }
        return ans;
    }
}
