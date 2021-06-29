//https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        int res = 0;
        Set<Character> seen = new HashSet<>();

        int l = 0;
        int r = 0;

        while (r < n) {
            while (seen.contains(s.charAt(r)))
                seen.remove(s.charAt(l++)); // end of current substring,slide the window

            seen.add(s.charAt(r++));
            res = Math.max(res, r - l);
        }

        return res;

    }
}
