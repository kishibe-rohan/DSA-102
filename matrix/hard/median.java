//Given a row-wise sorted matrix,find its median

public class median {
    int findMedian(int matrix[][], int r, int c) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Find max and min elements on the matrix
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] < min)
                min = matrix[i][0];

            if (matrix[i][c - 1] > max)
                max = matrix[i][c - 1];
        }

        // For median, we need n/2 elements less than total elements in the matrix
        int needed = (r * c + 1) / 2;

        // binary search for median in min-max range
        while (min < max) {
            int mid = min + (max - min) / 2;
            int position = 0; // position of mid in the matrix
            int index = 0; // index of mid in the row

            for (int i = 0; i < r; i++) {
                index = Arrays.binarySearch(matrix[i], mid);

                // mid is not an element of the row
                if (index < 0)
                    index = Math.abs(index) - 1;

                // mid is in matrix? find its last position in this row
                else {
                    while (index < matrix[i].length && matrix[i][index] == mid)
                        index += 1;
                }

                position = position + index;
            }

            if (position < needed)
                min = mid + 1;

            else
                max = mid;
        }

        return min;
    }
}
