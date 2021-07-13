//Question Link: https://leetcode.com/problems/score-of-parentheses
//answer will always be a sum of power of 2

class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                depth++; // increase depth
            else {
                depth--;
                if (s.charAt(i - 1) == '(')
                    ans += 1 << depth;
            }
        }

        return ans;
    }
}