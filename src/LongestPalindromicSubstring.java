public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int size = s.length();
        // arr[i][j]: s.substring(i, j + 1) is palindrome.
        boolean[][] arr = new boolean[size][size];
        int start = 0, end = 0;
        for (int i = 0; i < size; i++) {
            arr[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j + 1 || arr[j + 1][i -1]) {
                        arr[j][i] = true;
                    }
                }
                if (arr[j][i] && i - j > end - start) {
                    end = i;
                    start = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
