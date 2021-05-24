//Given an array of integers
//find the max and min element in the array
//Divide & Conquer

public class minandmaxpair {
    public static int[] main(int[] arr) {

        int[] minmax = solve(arr, 0, arr.length - 1);
        return minmax;

    }

    private static int[] solve(int[] a, int lo, int hi) {
        int mid;

        // initalize
        int[] minmax = new int[2];
        int[] mmleft = new int[2];
        int[] mmright = new int[2];

        // base case :only one element in the array
        if (lo == hi) {
            minmax[0] = arr[0];
            minmmax[1] = arr[0];
            return minmax;
        }

        // base case :two elements in the array
        if (hi == lo + 1) {
            if (a[lo] > a[hi]) {
                minmax[0] = a[hi];
                minmax[1] = a[lo];
                return minmax;
            } else {
                minmax[1] = a[hi];
                minmax[0] = a[lo];
                return minmax;
            }
        }

        // more than two elements
        mid = lo + (hi - lo) / 2;
        mmleft = solve(arr, lo, mid); // recur for left half
        mmright = solve(arr, mid + 1, hi); // recur for right half

        // compare left and right parts for overall min
        if (mmleft[0] < mmright[0]) {
            minmax[0] = mmleft[0];
        } else {
            minmax[0] = mmright[0];
        }

        // compare left and right parts for overall max
        if (mmleft[1] > mmright[1]) {
            minmax[1] = mmleft[1];
        } else {
            minmax[1] = mmright[1];
        }

        return minmax;

    }
}
