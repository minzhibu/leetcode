package leetCode;

import org.junit.Test;

public class Test0053 {

    @Test
    public void test0053() {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i-1];
            }
            if (nums[i] > sum) {
                sum = nums[i];
            }
        }
        return sum;
    }

}
