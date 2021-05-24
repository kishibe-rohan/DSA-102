public class sort012 {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 2, 1, 2, 0, 1, 2, 0 };
        int n = arr.length;
        // sort1(arr,n);
        sort2(arr, n);
    }

    private static void sort1(int a[], int n) {
        // Count the no. of 0s,1s and 2s.

        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                cnt0++;
            else if (a[i] == 1)
                cnt1++;
            else
                cnt2++;
        }

        int idx = 0;
        while (cnt0 > 0) {
            a[idx++] = 0;
            cnt0--;
        }
        while (cnt1 > 0) {
            a[idx++] = 1;
            cnt1--;
        }
        while (cnt2 > 0) {
            a[idx++] = 2;
            cnt2--;
        }
    }

    private static void sort2(int[] a, int n) {
        // Divide the array into 4 range
        // 1 to lo-1 (zeroes)
        // lo to mid-1 (ones)
        // mid to hi (unknown)
        // hi+1 to n (twos)
    }
}
