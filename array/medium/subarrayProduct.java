//Given an array of non-negative integers,find number of subarrays
//with product strictly less than k
//Approach: Two Pointers Sliding Window

public class subarrayProduct {
    public int findSubarrays(int[] arr, int k) {
        if (k <= 1)
            return 0;

        int prod = 1;
        int ans = 0;
        int l = 0;

        for (int r = 0; r < arr.length; r++) {
            prod *= arr[r];

            // exceeded product limit?
            while (prod >= k)
                prod /= arr[l++]; // limit elements from start of window

            ans += (r - l + 1); // add this window to ans
        }

        return ans;
    }
}
