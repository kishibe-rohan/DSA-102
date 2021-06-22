//Question Link : https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1

public class nextGreater {
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        long[] ans = new long[n];
        Stack<Integer> st = new Stack<Integer>();

        ans[n - 1] = -1;

        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            Long x = arr[i];
            if (x < arr[st.peek()]) {
                ans[i] = arr[st.peek()];
                st.push(i);
            } else {
                while (!st.isEmpty() && x >= arr[st.peek()])
                    st.pop();

                if (st.isEmpty())
                    ans[i] = -1;
                else
                    ans[i] = arr[st.peek()];

                st.push(i);
            }
        }

        return ans;
    }
}
