package leetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class Test0034 {

    @Test
    public void test01(){
        int[] ints = searchRange(new int[]{1,1,2}, 1);
        System.out.println(Arrays.toString(ints));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] num = new int[2];
        num[0] = -1;
        num[1] = -1;
        if(nums == null||nums.length == 0){
            return num;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int middle = (left+right)>>1;
            if(middle >= 0 && middle < nums.length && nums[middle] == target){
                int i = middle - 1;
                while(i >= 0 && nums[i] == target){
                    i--;
                }
                num[0] = i+1;
                i = middle + 1;
                while(i < nums.length && nums[i] == target){
                    i++;
                }
                num[1] = i-1;
                return num;
            }
            if(nums[middle] > target){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }
        return num;
    }
}
