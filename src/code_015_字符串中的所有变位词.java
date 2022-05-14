import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_015_字符串中的所有变位词 {
    public static void main(String[] args) {
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            ArrayList<Integer> list = new ArrayList<>();
            if (s.length() < p.length()) return list;
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            for (int i = 0; i < p.length(); i++) {
                cnt1[p.charAt(i) - 'a'] += 1;
                cnt2[s.charAt(i) - 'a'] += 1;
            }
            if (Arrays.equals(cnt1, cnt2)) list.add(0);
            int l = 1;
            int r = p.length();
            while (r < s.length()) {
                cnt2[s.charAt(l - 1) - 'a'] -= 1;
                cnt2[s.charAt(r) - 'a'] += 1;
                if (Arrays.equals(cnt1, cnt2)) list.add(l);
                l++;
                r++;
            }
            return list;
        }
    }
}
