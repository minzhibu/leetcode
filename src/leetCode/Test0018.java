package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Test0018 {

    /**
     * [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     */
    @Test
    public void test0018(){
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        List<List<Integer>> lists = fourSum(nums, -7);
        for(List<Integer> list:lists){
            System.out.println(list);
        }

    }
    //[[-5,-5,-1,4],[-5,-3,-1,2],[-5,-3,-1,2]]
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for(int l = i + 1;l<nums.length;l++) {
                int r = nums.length - 1;
                int min = l + 1;
                while (min < r && r < nums.length) {
                    if (nums[l] + nums[r] + nums[min] == temp) {
                        lists.add(Arrays.asList(nums[i], nums[l], nums[min], nums[r]));
                        while(nums[min] == nums[min+1]) {
                            min++;
                        }
                        min++;
                    } else if (nums[l] + nums[r] + nums[min] < temp) {
                        min++;
                    } else {
                        r--;
                    }
                }
                while(l<nums.length-1 && nums[l] == nums[l+1]) {
                    l++;
                }
            }
            while(i<nums.length-1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return lists;
    }
}
