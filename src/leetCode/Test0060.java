package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test0060 {

    @Test
    public void test0060() {
        String permutation = getPermutation(4, 9);
        System.out.println(permutation);
    }

    public String getPermutation(int n, int k) {
        //第一步:创建List<Integer>存放1-n的数
        // 第二步:计算temp = (n-1)!的结果，定义StringBuilder
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        k--;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            if (i != n) {
                res *= i;
            }
        }
        // 第三步:使用for(int i = n-1;list.size()!=0;i--）循环，
        for (int i = n - 1; list.size() != 0; i--) {
            // 第四步:K/temp list.remove出这个数append中StringBuilder
            sb.append(list.remove(k / res));
            // 第五步:k = k % temp
            k = k % res;
            // 第六步:temp = temp / i;
            if(i!=0){
                res = res / i;
            }else{
                res = 0;
            }
        }
        // 第七步返回StringBuilder
        return sb.toString();
    }
}
