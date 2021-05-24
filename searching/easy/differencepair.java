import javax.lang.model.util.ElementScanner6;

//Given an unsorted array of elements
//return true if a pair(i,j) exists such that
//a[j] - a[i] == target
//else return false

public class differencepair {
    public static boolean main(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);

        int i = 0, j = i + 1;
        while (i < n && j < n) {
            if (i != j && arr[j] - arr[i] == target)
                return true;

            else if (arr[j] - arr[i] < target)
                j++;

            else
                i++;
        }

        return false;
    }
}
