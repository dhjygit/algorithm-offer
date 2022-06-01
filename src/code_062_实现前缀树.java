import java.util.HashMap;

public class code_062_实现前缀树 {
    public static void main(String[] args) {
    }

    static class Trie {
        private final Trie[] next;
        private boolean isWord;

        public Trie() {
            next = new Trie[26];
            this.isWord = false;
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Trie();
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            return searchPrefix(word) != null && searchPrefix(word).isWord;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public Trie searchPrefix(String prefix) {
            Trie cur = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.next[c - 'a'] == null) return null;
                else cur = cur.next[c - 'a'];
            }
            return cur;
        }
    }

    static class Trie1 {
        private final HashMap<Character, Trie1> next;
        private boolean isWord;

        public Trie1() {
            next = new HashMap<>();
            this.isWord = false;
        }

        public void insert(String word) {
            Trie1 cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie1 trie1 = cur.next.getOrDefault(c, new Trie1());
                cur.next.put(c, trie1);
                cur = trie1;
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            Trie1 cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) return false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            Trie1 cur = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null) return false;
                cur = cur.next.get(c);
            }
            return true;
        }
    }
}
