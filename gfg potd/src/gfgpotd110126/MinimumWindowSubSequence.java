package gfgpotd110126;

public class MinimumWindowSubSequence {
    public static void main(String[] args) {
        String s1 = "abbbcdebdde";
        String s2 = "bde";
        System.out.println(minWindow(s1, s2));
    }
    public static String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // nextPos[i][ch] : next occurrence of character
        // ch after index i in s1
        int[][] nextPos = new int[n + 2][26];
        for (int c = 0; c < 26; c++) {
            nextPos[n][c] = -1; // initialize last row with -1
        }

        // fill table by going backwards through s1
        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                nextPos[i][c] = nextPos[i + 1][c];
            }
            nextPos[i][s1.charAt(i) - 'a'] = i;
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        // try starting at each position in s1
        for (int start = 0; start < n; start++) {
            if (s1.charAt(start) != s2.charAt(0)) continue;

            int idx = start;
            boolean ok = true;

            // match s2 by jumping through nextPos
            for (int j = 0; j < m; j++) {
                if (idx == -1) {
                    ok = false;
                    break;
                }
                idx = nextPos[idx][s2.charAt(j) - 'a'];
                if (idx == -1) {
                    ok = false;
                    break;
                }
                // move to next index for next char
                idx++;
            }

            if (ok) {
                int endIdx = idx - 1;
                int len = endIdx - start + 1;
                if (len < minLen) {
                    minLen = len;
                    ans = s1.substring(start, start + len);
                }
            }
        }

        return ans;
    }
}
