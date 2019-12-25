package leetCode;

import org.junit.Test;

public class Test0055 {

    @Test
    public void test0055() {
//        boolean b = canJump(new int[]{3,0,8,2,0,0,1});
        boolean b = canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6});
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        return isJump(nums, 0, 0, 0);
    }

    private boolean isJump(int[] nums, int n, int nextn, int max) {
        if (n >= nums.length - 1) {
            return true;
        }
        max = nums[n] > nums[max] ? n : max;
        if (nums[n] == 0) {
            if (nums[nextn] == 1 || (nums.length != 1 && n == nextn)) {
                if (nums[max] > n - max) {
                    return isJump(nums, nextn + 2, nextn, max);
                } else {
                    return false;
                }
            } else {
                if (nums[nextn + 1] == 0) {
//                    if (nextn < 1 || nums[nextn - 1] == 1 || nums[nextn-1] == 0) {
                    if (nextn < 1 || nums[nextn - 1] == 1 || nums[nextn - 1] == 0 || (nums[nextn - 1] < nums.length && nums[nums[nextn - 1]] == 0)) {
                        return false;
                    } else {
                        return isJump(nums, nextn - 1, nextn, max);
                    }
                }
                return isJump(nums, nextn + 1, nextn, max);
            }
        } else {
            return isJump(nums, n + nums[n], n, max);
        }
    }
}
