package leetCode;

import org.junit.Test;

public class Test0052 {
    private int count;

    @Test
    public void test0022(){
        int i = totalNQueens(4);
        System.out.println(i);
    }

    public int totalNQueens(int n) {
        int[] arr = new int[n];
        solveNQueens(arr,0,n);
        return count;
    }
    private void solveNQueens( int[] arr, int m , int n){
        if(m == n){
            count++;
            return;
        }
        for(int i = 0 ; i < n ;i++){
            arr[m] = i;
            if(isConflict(arr,m)){
                solveNQueens(arr,m+1,n);
            }
        }
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
