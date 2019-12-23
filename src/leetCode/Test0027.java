package leetCode;

import org.junit.Test;

public class Test0027 {

    @Test
    public void test0027(){
        removeElement(new int[]{0,1,2,2,3,0,4,2,2,2,2,2},2);
    }
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length ; j++){
            if(nums[j]!=val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
