//Given a sorted array of integers,return first and last index of element x
//return [-1,-1] if element not in array
//Time Complexity -> O(logN) using Binary Search
//Naive approach -> Linear Search O(1)

public class occurencesofx {
    public static int[] main(int[] arr, int target) {
        int first = binSearch(arr, target);
        if (first == arr.length || arr[first] != target) {
            return new int[] { -1, -1 };
        }

        return new int[] { start, binSearch(arr, target + 1) - 1 };
    }

    private static int binSearch(int[] arr, int target) {
        // retruns index of first element greater than or equal to target
        // for left boundary,we search first occurence of target
        // for right boundary,we search first occurenece of target + 1;

        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
