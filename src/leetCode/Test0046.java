package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0046 {

    @Test
    public void test0046(){
        List<List<Integer>> permute = permute(new int[]{1, 1, 2});
        System.out.println(permute);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(lists,list,nums,0);
        return lists;
    }
    private void permute(List<List<Integer>> lists, List<Integer> list, int[] nums , int num){
        if(list.size() == nums.length){
            lists.add(list);
            return;
        }
        for(int i = 0; i < nums.length ; i++){
            if(list.contains(nums[i])){
                continue;
            }
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[i]);
            permute(lists,temp,nums,i+1);
        }
    }
}
