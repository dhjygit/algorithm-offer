public class code_069_山峰数组的顶部 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0;
            int r = arr.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] > arr[mid + 1]) r = mid;
                else l = mid + 1;
            }
            return l;
        }
    }
}


