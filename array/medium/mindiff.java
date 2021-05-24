public class mindiff {
    public static int main(String[] args) {
        int arr[] = { 4, 2, 3, 6 };
        int k = 3;
        Arrays.sort(arr);

        int n = arr.length;
        // [2,3,4,6]
        int ans = arr[n - 1] - arr[0]; // 4

        int big = arr[n - 1] - k; // 3
        int small = arr[0] + k; // 5

        int temp = 0;
        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        for (int i = 1; i < n - 1; i++) {

            // 0/1 Knapsack
            int add = arr[i] + k;
            int sub = arr[i] - k;

            // adding or subtracting doesnt change diff?
            if (sub >= small || add <= big)
                continue;

            if (big - sub <= add - small)
                small = sub;
            else
                big = add;
        }

        return Math.min(ans, big - small);

    }
}
