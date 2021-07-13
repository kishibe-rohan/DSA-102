//Question Link:  https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
//Similar to Next Greater Element

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int n = prices.length;

        st.push(prices[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            int curr = prices[i];

            // remove larger elements
            while (!st.isEmpty() && curr < st.peek())
                st.pop();

            int discount = st.isEmpty() ? 0 : st.peek();
            prices[i] = prices[i] - discount;

            st.push(curr);
        }

        return prices;
    }
}