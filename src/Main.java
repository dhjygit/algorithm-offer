public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution1().LCS("22222", "22222"));
        System.out.println(new Solution2().LCS("22222", "22222"));
    }
}

class Solution1 {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int length = 0;
        int index = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > length) {
                        index = i - 1;
                        length = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(index - length + 1, index + 1);
    }
}


class Solution2 {
    public String LCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int length = 0;
        int index = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > length) {
                        length = dp[i][j];
                        index = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(index - length + 1, index + 1);
    }
}