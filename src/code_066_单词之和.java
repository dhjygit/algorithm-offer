import java.util.HashMap;
import java.util.Map;

public class code_066_单词之和 {
    public static void main(String[] args) {
    }

    static class MapSum {
        private final MapSum[] next;
        private boolean isWord;
        private int val;

        public MapSum() {
            this.next = new MapSum[26];
            this.isWord = false;
            this.val = 0;
        }

        public void insert(String key, int val) {
            MapSum cur = this;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new MapSum();
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
            cur.val = val;
        }

        public int sum(String prefix) {
            MapSum cur = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.next[c - 'a'] == null) return 0;
                else cur = cur.next[c - 'a'];
            }
            return traversal(cur);
        }

        private int traversal(MapSum node) {
            int sum = 0;
            for (MapSum mapSum : node.next) if (mapSum != null) sum += traversal(mapSum);
            return node.isWord ? sum + node.val : sum;
        }
    }
}

class MapSum {
    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new TrieNode();
            node = node.next[c - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) return 0;
            node = node.next[c - 'a'];
        }
        return node.val;
    }
}
