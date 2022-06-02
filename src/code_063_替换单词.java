import java.util.List;

public class code_063_替换单词 {
    public static void main(String[] args) {
    }

    static class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            StringBuilder stringBuilder = new StringBuilder();
            Trie trie = new Trie();
            for (String word : dictionary) trie.insert(word);
            String[] sen = sentence.split(" ");
            for (String word : sen)
                if (trie.findPrefix(word) == null) stringBuilder.append(word).append(" ");
                else stringBuilder.append(trie.findPrefix(word)).append(" ");
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }

        static class Trie {
            private final Trie[] next = new Trie[26];
            private boolean isWord;

            public void insert(String word) {
                Trie cur = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Trie();
                    cur = cur.next[c - 'a'];
                }
                cur.isWord = true;
            }

            public String findPrefix(String word) {
                Trie cur = this;
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.next[c - 'a'] == null) return null;
                    stringBuilder.append(c);
                    cur = cur.next[c - 'a'];
                    if (cur.isWord) return stringBuilder.toString();
                }
                return null;
            }
        }
    }
}
