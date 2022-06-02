public class code_065_最短的单词编码 {
    public static void main(String[] args) {
        new Solution().minimumLengthEncoding(new String[]{"me", "time"});
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        int length = 0;
        Trie trie = new Trie();
        for (String word : words) {
            String newWord = new StringBuilder(word).reverse().toString();
            int value = trie.startsWith(newWord);
            if (value != 0) {
                length += value;
                continue;
            }
            trie.add(newWord);
            length += word.length() + 1;
        }
        return length;
    }

    static class Trie {
        private final Trie[] next = new Trie[26];
        private boolean isWord;

        public void add(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null)
                    cur.next[c - 'a'] = new Trie();
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        public int startsWith(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null && !cur.isWord) return 0;
                else if (cur.next[c - 'a'] == null && cur.isWord) {
                    cur.isWord = false;
                    this.add(word);
                    return word.length() - i - 1;
                } else cur = cur.next[c - 'a'];
            }
            return 0;
        }
    }
}