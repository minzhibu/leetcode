package leetCode;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */
public class Test0049 {

    @Test
    public void test0049(){
        List<List<String>> lists = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(lists);

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap<>();
        for(int i = 0; i < strs.length ;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
