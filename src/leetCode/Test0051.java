package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Test0051 {

    @Test
    public void test0051(){
        List<List<String>> lists = solveNQueens(8);
        System.out.println(lists);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        int[] arr = new int[n];
        // char[] chars = new char[n][n];
        // for(int i = 0 ; i < n ;i++){
        //     for(int j = 0; j < n;j++){
        //         chars[i][j] = '.';
        //     }
        // }
        solveNQueens(lists,arr,0,n);
        return lists;
    }
    private void solveNQueens(List<List<String>> lists ,int[] arr,int m ,int n){
        if(m == n){
            List<String> list = new ArrayList<>();
            char[][] chars = new char[n][n];
            for(int i = 0; i < n ;i++){
                for(int j = 0 ; j < n ; j++){
                    chars[i][j] = '.';
                }
                chars[i][arr[i]] = 'Q';
                list.add(new String(chars[i]));
            }
            lists.add(list);
            return;
        }
        for(int i = 0 ; i < n ;i++){
            arr[m] = i;
            if(isConflict(arr,m)){
                solveNQueens(lists,arr,m+1,n);
            }
        }
        // for(int i = 0; i < n ; i++){
        //     char[m][i] = 'Q';
        //     if()
        // }
    }
    private boolean isConflict(int[] arr , int m){
        for(int i = 0 ; i < m ; i++){
            if(arr[i] == arr[m] || Math.abs(m-i) == Math.abs(arr[m] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
