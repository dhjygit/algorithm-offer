import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class code_035_最小时间差 {
    public static void main(String[] args) {
        new Solution().findMinDifference(Arrays.asList("23:59", "00:00"));
    }

    static class Solution {
        public int findMinDifference(List<String> timePoints) {
            Collections.sort(timePoints);
            int result = Integer.MAX_VALUE;
            int startime = Integer.MAX_VALUE;
            int endtime = Integer.MAX_VALUE;
            for (int i = 0; i < timePoints.size() - 1; i++) {
                int time1 = parseTime(timePoints.get(i));
                int time2 = parseTime(timePoints.get(i + 1));
                result = Math.min(result, Math.abs(time1 - time2));
                if (i == 0) startime = time1;
                if (i + 1 == timePoints.size() - 1) endtime = time2;
            }
            result = Math.min(result, 24 * 60 - endtime + startime);
            return result;
        }

        private int parseTime(String str) {
            return ((str.charAt(0) - 'a') * 10 + str.charAt(1) - 'a') * 60 + (str.charAt(3) - 'a') * 10 + str.charAt(4) - 'a';
        }
    }

    static class Solution1 {
        public int findMinDifference(List<String> timePoints) {
            Collections.sort(timePoints);
            int result = Integer.MAX_VALUE;
            int startime = Integer.MAX_VALUE;
            int endtime = Integer.MAX_VALUE;
            for (int i = 0; i < timePoints.size() - 1; i++) {
                int time1 = parseTime(timePoints.get(i));
                int time2 = parseTime(timePoints.get(i + 1));
                result = Math.min(result, Math.abs(time1 - time2));
                if (i == 0) startime = time1;
                if (i + 1 == timePoints.size() - 1) endtime = time2;
            }
            result = Math.min(result, 24 * 60 - endtime + startime);
            return result;
        }

        private int parseTime(String str) {
            int hour = Integer.parseInt(str.substring(0, 2));
            int minute = Integer.parseInt(str.substring(3, 5));
            return hour * 60 + minute;
        }
    }
}
