package leetCode;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test0056 {

    @Test
    public void test0056() {
        int[][] nums = new int[][]{{2, 3}, {10, 12}, {13, 15}, {0, 7}, {4, 8}};

        int[][] merge = merge2(nums);
//        helperSort(nums, 0, nums.length - 1);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j]);
            }
            System.out.println();
        }

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] nums = new int[intervals.length][intervals[0].length];
        nums[0] = intervals[0];
        int indexNums = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (nums[indexNums][1] >= intervals[i][0] && nums[indexNums][1] < intervals[i][1]) {
                nums[indexNums][1] = intervals[i][1];
            }
            if (nums[indexNums][1] < intervals[i][0]) {
                nums[++indexNums] = intervals[i];
            }
        }
        return nums;
    }

    public int[][] merge1(int[][] intervals) {
        if(intervals.length <1){
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // int[][] nums = new int[intervals.length][2];
        List<int[]> lists = new ArrayList<>();
        // nums[0] = intervals[0];
        lists.add(intervals[0]);
        int indexNums = 0;
        for (int i = 1; i < intervals.length; i++) {
            //if (nums[indexNums][1] >= intervals[i][0] && nums[indexNums][1] < intervals[i][1]) {
            if (lists.get(lists.size()-1)[1] >= intervals[i][0] && lists.get(lists.size()-1)[1] < intervals[i][1]) {
                // nums[indexNums][1] = intervals[i][1];
                lists.get(lists.size()-1)[1] = intervals[i][1];
            }
            if (lists.get(lists.size()-1)[1] < intervals[i][0]) {
                // nums[++indexNums] = intervals[i];
                lists.add(intervals[i]);
            }
        }
        // int[][] arr = new int[indexNums+1][2];
        // for (int i = 0; i <= indexNums; i++) {
        // arr[i] = nums[i];
        // }
        return  lists.toArray(new int[lists.size()][2]);
    }

    public Object clone(Object object) {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        Object object1 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object1 = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object1;
    }

    private void helperSort(int[][] nums, int left, int right) {
        int l = left;
        int r = right;
        int pivot = nums[(left + right) / 2][0];
        int[] temp;
        while (l < r) {
            while (nums[l][0] < pivot) {
                l++;
            }
            while (nums[r][0] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if (nums[l][0] == pivot) {
                --r;
            }
            if (nums[r][0] == pivot) {
                ++l;
            }
        }
        if (l == r) {
            ++l;
            --r;
        }
        if (l < right) {
            helperSort(nums, l, right);
        }
        if (r > left) {
            helperSort(nums, left, r);
        }
    }

    public int[][] merge2(int[][] intervals) {
        int len = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval != null){
                for (int j = i+1; j < intervals.length; j++) {
                    int[] interval2 = intervals[j];
                    if(interval2 != null && ((interval[1] >= interval2[0] && interval[0] <= interval2[1]) || (interval2[1] >= interval[0] && interval2[0] <= interval[1]))){
                        interval2[0] = interval[0]<interval2[0]?interval[0]:interval2[0];
                        interval2[1] = interval[1]>interval2[1]?interval[1]:interval2[1];
                        intervals[i] = null;
                        len--;
                        break;
                    }
                }
            }
        }
        if(len == intervals.length){
            return intervals;
        }

        int[][] ints = new int[len][];
        int i = 0;
        for (int[] interval : intervals) {
            if(interval != null){
                ints[i++] = interval;
            }
        }

        return ints;
    }
}
