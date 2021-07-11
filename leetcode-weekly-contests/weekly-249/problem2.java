//Question Link : https://leetcode.com/contest/weekly-contest-249/problems/unique-length-3-palindromic-subsequences/ 

class Solution {
    public int countPalindromicSubsequence(String s) {
        // keep track of first and last occurences of characters in the string
        // the character can be included in palindrome for every distinct middle
        // character
        // eg: "bcaeb" => first occurence and last occurence of b are at 0 and 4 indices
        // b can appear in len-3 palindromes bcb,bab,beb

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, Integer.MAX_VALUE);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            first[c - 'a'] = Math.min(first[c - 'a'], i);
            last[c - 'a'] = i;
        }

        int count = 0;
        HashSet<Character> distinct = new HashSet<>();

        // for every letter appearing in the string
        for (int i = 0; i < 26; i++) {
            if (first[i] != Integer.MAX_VALUE && last[i] - first[i] > 1) {
                // get the count of distinct characters between its first and last occurences
                distinct.clear();
                for (int j = first[i] + 1; j < last[i]; j++)
                    distinct.add(s.charAt(j));
                count += distinct.size();
            }
        }

        return count;
    }
}
