class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int m = word1.length();
        int n = word2.length();

        int i = 0;
        int j = 0;

        int turn = 0;

        while (i < m && j < n) {
            if (turn % 2 == 0)
                merged.append(word1.charAt(i++));

            else
                merged.append(word2.charAt(j++));

            turn++;
        }

        while (i < m)
            merged.append(word1.charAt(i++));

        while (j < n)
            merged.append(word2.charAt(j++));

        return merged.toString();

    }
}