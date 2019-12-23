package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Test0047 {



    @Test
    public void test0046() {
        List<List<Integer>> permute = permute(new int[]{1, 1, 2});
        System.out.println(permute);
    }
    private boolean[] isYes;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        isYes = new boolean[nums.length];
        permute(lists, list, nums, 0);
        return lists;
    }

    private void permute(List<List<Integer>> lists, List<Integer> list, int[] nums, int num) {
        if (list.size() == nums.length) {
            lists.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(list);
            if (isYes[i]) {
                continue;
            }
            if(i >0 && nums[i] == nums[i-1] && !isYes[i-1]){
                continue;
            }
            temp.add(nums[i]);
            isYes[i] = true;
            permute(lists, temp, nums, i + 1);
            isYes[i] = false;
        }
    }
}
