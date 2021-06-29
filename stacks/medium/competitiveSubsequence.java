// Question Link: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3611

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[k];

        for (int i = 0; i < nums.length; i++) {
            // make sure we have enough elements to satisfy constraint of 'k'
            while (!st.isEmpty() && nums[i] < nums[st.peek()] && nums.length - i + st.size() > k)
                st.pop();

            if (st.size() < k)
                st.push(i);
        }

        for (int i = k - 1; i >= 0; i--)
            res[i] = nums[st.pop()];

        return res;

    }
}
