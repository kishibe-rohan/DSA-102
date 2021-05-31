//Given a sorted MxN 2D matrix
//efficiently find if an element exists in the matrix or not
//O(logM) + O(logN)

public class search2Dmatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // treat it as a sorted 1D list
        // if c is the number of columns
        // matrix[x][y] ==> arr[c*x + y]
        // arr[x] ==> matrix[x/m][x%m];

        int r = matrix.length;
        int c = matrix[0].length;

        int low = 0, high = r * c - 1;

        while (low != high) {
            int mid = (low + high - 1) >> 1; // avoid overflow
            if (matrix[mid / c][mid % c] < target)
                low = mid + 1;
            else
                high = mid;
        }

        return matrix[high / c][high % c] == target;
    }

}
