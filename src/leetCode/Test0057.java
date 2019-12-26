package leetCode;

import org.junit.Test;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Test0057 {

//    public int[][] insert(int[][] intervals, int[] newInterval) {
//
//    }

    @Test
    public void test0057() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{13, 17};
        int left = find(intervals, 0, 0, intervals.length - 1, newInterval[0]);
        int right = find(intervals, 1, 0, intervals.length - 1, newInterval[1]);
        int index = (left == right ? 1 : left - right);
        if (right < intervals.length && intervals[right][0] == newInterval[1]) {
            index--;
            newInterval[1] = intervals[right++][1];
        }
        if (left != right) {
            newInterval[0] = intervals[left - 1][0];
        }
        if (left - 1 < intervals.length && left == right && newInterval[0] < intervals[left - 1][1]) {
            left -= 2;
            index -= 2;
            newInterval[0] = intervals[left][0];
        }
//        left--;
        int[][] newIntervals = new int[intervals.length + index][2];
        int intervalsIndex = 0;
//        System.out.println(right);
        for (int i = 0; i < newIntervals.length; i++) {
            if (i == left) {
                if (left == right) {
                    newIntervals[i] = newInterval;
                } else {
                    newIntervals[i][0] = newInterval[0];
                    newIntervals[i][1] = newInterval[1];
                    intervalsIndex = right;
                }
            } else {
                newIntervals[i] = intervals[intervalsIndex++];
            }
        }
        for (int i = 0; i < newIntervals.length; i++) {
            for (int j = 0; j < newIntervals[i].length; j++) {
                System.out.print(newIntervals[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int find(int[][] intervals, int num, int left, int right, int target) {
        if (target < intervals[left][num]) {
            return 1;
        }
        if (target > intervals[right][num]) {
            return right + 1;
        }
        int min = (left + right) / 2;
        if (intervals[min][num] <= target && intervals[min + 1][num] > target) {
            return min + 1;
        }
        if (intervals[min][num] < target) {
            return find(intervals, num, min + 1, right, target);
        } else {
            return find(intervals, num, left, min - 1, target);
        }
    }
}
