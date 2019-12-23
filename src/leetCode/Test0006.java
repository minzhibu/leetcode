package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test0006 {

    @Test
    public void test01() {
        String s = "LEETCODEISHIRING";
        String convert = convert(s, 3);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
    public String convert1(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0 ; i < Math.min(s.length(),numRows);i++){
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for(char c : s.toCharArray()){
            list.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1){
                goingDown = !goingDown;
            }
            curRow += goingDown?1:-1;
        }
        StringBuilder builder = new StringBuilder();
        for(StringBuilder stringBuilder : list){
            builder.append(stringBuilder);
        }
        return builder.toString();
    }

}
