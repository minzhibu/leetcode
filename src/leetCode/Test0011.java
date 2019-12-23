package leetCode;

import org.junit.Test;

public class Test0011 {

    @Test
    public void test01() {
        int i = maxArea(new int[]{1,2,4,3});
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxarea = 0;
        while(l<r){
            maxarea = Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
}
