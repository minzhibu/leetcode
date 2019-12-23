package leetCode;

import org.junit.Test;

public class Test0009 {

    @Test
    public void test01(){
        boolean palindrome = isPalindrome(Integer.MAX_VALUE);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int len = (x+"").length()/2;
        int temp = 0 ;
        int xtemp = x;
        int n = 1;
        for(int i = 0 ; i < len ; i++){
            int index = x %10;
            x /= 10;
            n *= 10;
            temp = temp *10 + index;
        }
        System.out.println((xtemp+"").length());
        if((xtemp+"").length()%2==1){
            n *= 10;
        }
        return xtemp/n == temp;

    }
}
