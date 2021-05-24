//Given an unsorted array of size N of positive integers 
// in the range 1-N..
// one number X occurs twice 
// one number Y is missing
// Find X and Y in O(N) time

public class missingandrepeating {
    public static void main(int[] arr, int n) {
        int missing = -1;
        int repeating = -1;

        // to find repeating number
        // traverse the array and negate the value at a[abs(a[i])]
        // if we come across a value that is already negative
        // we know that a[i] has been repeated

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]);
            if (arr[idx - 1] > 0)
                arr[idx - 1] = -arr[idx - 1];
            else
                repeating = idx;
        }

        // to find missing number
        // traverse the array again
        // if we come across a positive value
        // missing number is i + 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                missing = i + 1;
        }

        System.out.println(missing);
        System.out.println(repeating);

    }
}
