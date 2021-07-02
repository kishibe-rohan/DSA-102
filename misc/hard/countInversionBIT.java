/*Given an array of size n,count the number of inversions in the array
arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j
For array sorted in ascending order,inversion count is 0;
*/

/*
Approach: Use Fenwick Tree
1. Convert the array elements into their indices in sorted array
eg: arr[] = {-3,7,3,5} becomes {1,4,2,3} as that would be their indices(+1) if array were sorted

2. Traverse from end of the array and add the frequency count of elements less than current element to result.
3. Update the frequency count for current element and its ancestors

Time Complexity => O(nlogn)
Space Complexity => O(n)
*/

public class countInversionBIT {
    public static int main(String[] args) {
        int[] arr = { -3, 7, 5, 3 };
        itn n = arr.length;
        return invCount(arr, n);
    }

    public static int invCount(int[] arr, int n) {
        int count = 0;
        convert(arr, n);

        int[] BIT = new int[n + 1];

        // initialize
        for (int i = 1; i <= n; i++)
            BIT[i] = 0;

        // construct and update
        for (int i = n - 1; i >= 0; i--) {
            // get frequency count of smaller elements
            count += getFreq(BIT, arr[i] - 1);
            update(BIT, n, arr[i], 1);
        }

        return count;
    }

    static void convert(int[] arr, int n) {
        int[] temp = new int[n];

        for (int i = 0; i < n; i++)
            temp[i] = arr[i];

        Arrays.sort(temp);
        for (int i = 0; i < n; i++)
            arr[i] = getIndex(temp, 0, n, arr[i]) + 1;
    }

    static int getIndex(int[] a, int low, int high, int x) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    static int getFreq(int BIT[], int i) {
        int freqCount = 0;

        while (i > 0) {
            freqCount += BIT[i];
            i -= i & (-i);
        }

        return freqCount;
    }

    static void update(int BIT[], int n, int i, int val) {
        while (i <= n) {
            BIT[i] += val;
            i += i & (-i);
        }
    }

}
