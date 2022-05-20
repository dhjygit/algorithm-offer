public class code_032_有效的变位词 {
    public static void main(String[] args) {
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length() || s.equals(t)) return false;
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
                cnt[t.charAt(i) - 'a']--;
            }
            for (int c : cnt) if (c != 0) return false;
            return true;
        }
    }
}
