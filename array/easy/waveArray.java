//Question Link: https://practice.geeksforgeeks.org/problems/wave-array-1587115621 
//Approach: swap elements at odd and even indices as pairs

class Solution {
    // arr: input array
    // n: size of the array
    // Function to sort the array into a wave-like array.
    public static void convertToWave(int arr[], int n) {

        // Your code here
        if (n == 1)
            return;

        int even = 0;
        int odd = 1;

        while (odd < n && even < n) {
            int temp = arr[even];
            arr[even] = arr[odd];
            arr[odd] = temp;

            even += 2;
            odd += 2;
        }

        return;

    }

}