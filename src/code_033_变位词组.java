import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class code_033_变位词组 {
    public static void main(String[] args) { /*        new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});*/}

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String newStr = new String(arr);
                if (!map.containsKey(newStr)) map.put(newStr, new ArrayList<>());
                map.get(newStr).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

    static class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<List<Integer>, List<String>> map = new HashMap<>();
            for (String str : strs) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < 26; i++) list.add(0);
                for (int i = 0; i < str.length(); i++) {
                    int c = str.charAt(i) - 'a';
                    list.set(c, list.get(c) + 1);
                }
                if (!map.containsKey(list)) map.put(list, new ArrayList<>());
                map.get(list).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
}
