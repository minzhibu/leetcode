package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0040 {

    @Test
    public void test0040(){
        List<List<Integer>> lists = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates,lists,list,target,0);
        return lists;
    }
    private void combinationSum2(int[] candidates,List<List<Integer>> lists, List<Integer> list,int target,int num){
        if(target == 0){
            if(!lists.contains(list)){
                lists.add(list);
            }
            return;
        }
        if(target < candidates[0]){
            return;
        }
        for(int i = num ; i < candidates.length && candidates[i] <= target ; i++){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[i]);
            combinationSum2(candidates,lists,temp,target-candidates[i],i+1);
        }
    }
}
