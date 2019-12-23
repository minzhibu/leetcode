package leetCode;

import org.junit.Test;

public class Test0043 {

    @Test
    public void test0043(){
        String multiply = multiply("123", "456");
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
            return "";
        }
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        int[] nums = new int[n1+n2+2];
        for(int i = n1 ; i >= 0 ; --i){
            for (int j = n2; j >= 0 ;--j ){
                int sum = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                sum += nums[i+j+1];
                nums[i+j] += sum / 10;
                nums[i+j+1] = sum % 10;
            }
        }
        int i = 0;
        while(i < nums.length && nums[i] == 0){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(i < nums.length){
            sb.append(nums[i]);
            i++;
        }
        return sb.toString();
    }
}
