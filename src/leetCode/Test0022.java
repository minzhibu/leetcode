package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Test0022 {

    @Test
    public void test0022() {
        List<String> list = generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(list,"",0,0,n);
        return list;

    }

    public void generateParenthesis(List<String> list,String str,int open,int close,int max){
        if(str.length()==2*max){
            list.add(str);
            return;
        }
        if(open<max){
            generateParenthesis(list,str+"(",open+1,close,max);
        }
        if(close<open){
            generateParenthesis(list,str+")",open,close+1,max);
        }
    }

}
