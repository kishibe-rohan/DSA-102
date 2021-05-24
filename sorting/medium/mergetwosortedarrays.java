//Given two sorted arrays arr1 and arr2
//len(arr1) => m
//len(arr2) => n
//Modify them such that arr1 contains the 'm' smallest elements of both arrays
//and arr2 contaisn the remaining n elements
//No extra space to be used

//Algorithm -> Insertion Sort O(m*n)

public class mergetwosortedarrays {
    public static void main(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        // iterate arr2 from right to left
        // store last element of arr1 in temp
        // compare arr2[i] with arr1[j] elements
        // and insert it at appropriate place in arr1
        // replace arr2[i] with temp

        for (int i = n - 1; i >= 0; i--) {
            int j, temp = arr1[m - 1];
            for (j = m - 2; j >= 0 && a[j] > b[i]; j--)
                a[j + 1] = a[j];

            // b[i] belongs in a[]? swap
            if (j != m - 2 || temp > b[i]) {
                a[j + 1] = b[i];
                b[i] = temp;
            }
        }
    }

}
