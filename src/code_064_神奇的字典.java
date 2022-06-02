public class code_064_神奇的字典 {
    public static void main(String[] args) {
        MagicDictionary1 magicDictionary1 = new MagicDictionary1();
        magicDictionary1.buildDict(new String[]{"hello", "leetcode"});
        magicDictionary1.search("hello"); // 返回 False
        magicDictionary1.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        magicDictionary1.search("hell"); // 返回 False
        magicDictionary1.search("leetcoded"); // 返回 False
    }

    static class MagicDictionary1 {
        private final MagicDictionary1[] next;
        private boolean isWord;

        public MagicDictionary1() {
            next = new MagicDictionary1[26];
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                MagicDictionary1 cur = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new MagicDictionary1();
                    cur = cur.next[c - 'a'];
                }
                cur.isWord = true;
            }
        }

        public boolean search(String searchWord) {
            StringBuilder stringBuilder = new StringBuilder(searchWord);
            for (int i = 0; i < stringBuilder.length(); i++) {
                char c = stringBuilder.charAt(i);
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == c) continue;
                    stringBuilder.setCharAt(i, j);
                    if (match(stringBuilder.toString())) return true;
                }
                stringBuilder.setCharAt(i, c);
            }
            return false;
        }

        private boolean match(String word) {
            MagicDictionary1 cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) return false;
                else cur = cur.next[c - 'a'];
            }
            return cur.isWord;
        }
    }
}

