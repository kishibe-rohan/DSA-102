//Question Link: https://leetcode.com/problems/remove-duplicate-letters

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26]; // count number of occurences of each letter in the string
        boolean[] included = new boolean[26]; // whether this character is already present in final answer

        char[] ch = s.toCharArray();
        for (char c : ch)
            freq[c - 'a']++;

        Stack<Character> st = new Stack<>();
        int index;

        for (char c : ch) {
            index = c - 'a';
            freq[index]--; // decrement frequency of current character
            if (included[index])
                continue; // already included in res string,dont need to include again

            // if a larger charcter in stack occurs later,we can just add it later
            while (!st.isEmpty() && c < st.peek() && freq[st.peek() - 'a'] != 0)
                included[st.pop() - 'a'] = false; // mark as not included

            st.push(c);
            included[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.insert(0, st.pop());

        return sb.toString();
    }
}
