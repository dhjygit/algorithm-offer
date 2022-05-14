import java.util.Arrays;

public class code_014_字符串中的变位词 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab", "eidba"));
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;
            int[] cnt = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                cnt[s1.charAt(i) - 'a']--;
                cnt[s2.charAt(i) - 'a']++;
            }
            int diff = 0;
            for (int n : cnt) diff += n == 0 ? 0 : 1;
            if (diff == 0) return true;
            int l = 1;
            int r = s1.length();
            while (r < s2.length()) {
                int x = s2.charAt(r) - 'a';
                int y = s2.charAt(l - 1) - 'a';
                if (x != y) {
                    if (cnt[x] == 0) diff++;
                    if (cnt[y] == 0) diff++;
                    if (++cnt[x] == 0) diff--;
                    if (--cnt[y] == 0) diff--;
                    if (diff == 0) return true;
                }
                l++;
                r++;
            }
            return false;
        }
    }

    static class Solution1 {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                cnt1[s1.charAt(i) - 'a'] += 1;
                cnt2[s2.charAt(i) - 'a'] += 1;
            }
            if (Arrays.equals(cnt1, cnt2)) return true;
            int l = 1;
            int r = s1.length();
            while (r < s2.length()) {
                cnt2[s2.charAt(r) - 'a'] += 1;
                cnt2[s2.charAt(l - 1) - 'a'] -= 1;
                if (Arrays.equals(cnt1, cnt2)) return true;
                l++;
                r++;
            }
            return false;
        }
    }
}

