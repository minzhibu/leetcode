package leetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Test0013 {

    @Test
    public void test01(){
        int mcmxciv = romanToInt("IV");
        System.out.println(mcmxciv);
    }

    public int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String,Integer> map = new HashMap<>();
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
        int index = 0;
        Integer num;
        Integer sum = 0;
        while(index < s.length()){
            if(index+2<=s.length()) {
                num = map.get(s.substring(index, index + 2));
            }else{
                num = null;
            }
            if(num == null){
                num = map.get(s.substring(index,index+1));
                index++;
            }else{
                index += 2;
            }
            sum += num;
        }
        return sum;
    }
}
