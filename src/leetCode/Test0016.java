package leetCode;

import org.junit.Test;

import java.util.Arrays;

public class Test0016 {

    @Test
    public void test01() {
        int i = threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE - Math.abs(target);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                int sum = temp - target;
                if (sum == 0) {
                    return target;
                } else if (sum > 0) {
                    if (Math.abs(min - target) > Math.abs(sum)) {
                        min = temp;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                } else {
                    if (Math.abs(min - target) > Math.abs(sum)) {
                        min = temp;
                    }
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                }
            }
        }
        return min;
    }
}
