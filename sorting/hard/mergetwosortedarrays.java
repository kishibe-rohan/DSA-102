//Given two sorted arrays arr1 and arr2
//len(arr1) => m
//len(arr2) => n
//Modify them such that arr1 contains the 'm' smallest elements of both arrays
//and arr2 contaisn the remaining n elements
//No extra space to be used

//Algorithm -> Optimized Insertion Sort O(nlogn + mlogm)

public class mergetwosortedarrays {
    public static void main(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        int i = 0;
        int j = 0;
        int k = m - 1;

        // traverse both arrays
        // if b[j] < a[i],swap it with kth element of a[i]
        // sort both arrays

        while (i <= k && j < n) {
            if (a[i] < b[j])
                i++;
            else {
                int temp = b[j];
                b[j] = a[k];
                a[k] = temp;
                j++;
                k--;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

}
