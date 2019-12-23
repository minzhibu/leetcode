package leetCode;

import org.junit.Test;

public class Test005 {

    public static void main(String[] args) {
        String s = "babad";
        Test005 test005 = new Test005();
        String s1 = test005.longestPalindrome(s);
        System.out.println(s1);
    }
    @Test
    public void test02(){
        String s = "bb";
        String s1 = longestPalindrome1(s);
        System.out.println(s1);
    }
    public String longestPalindrome1(String s) {
        if(s.length() < 2 || s == null ){
            return s;
        }
        int max = 1;
        int left;
        int right;
        int temp;
        String target = s.substring(0,1);
        for(int i = 0 ; i < (s.length() * 2 - 1) ; i++){
            temp = i/2;
            if (i % 2 == 0) {
                left = temp;
                right = temp+1;
            }else{
                left = temp-1;
                right = temp+1;
            }
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    --left;
                    ++right;
                }else{
                    break;
                }
            }
            ++left;
            if(max < (right - left)){
                max = right - left;
                target = s.substring(left,right);
            }
        }
        return target;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int num = 0;
        String temp = null;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPlalindrome(s.substring(i, j+1))) {
                    int len1 = j - i + 1;
                    if (num < len1) {
                        num = len1;
                        temp = s.substring(i,j+1);
                    }
                }
            }
        }
        return temp==null?s.substring(0,1):temp;
    }

    public boolean isPlalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    @Test
    public void test01(){
        String substring = "asd".substring(0, 1);
        System.out.println(substring);
    }
}
