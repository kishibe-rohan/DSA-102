//Given a MxN matrix,print its spiral traversal
//Idea: Traverse  in order:left to right,top to bottom.right to left and bottom to top
//check & maintain boundaries

public class spiralMatrix {
    public static void main(int matrix[][], int r, int c) {
        int i; // iterator
        int r1 = 0; // starting index of row
        int c1 = 0; // starting index of col

        while (r1 < r && c1 < c) {
            // left to right
            for (i = c1; i < c; i++) {
                System.out.print(matrix[r1][i]);
            }

            r1++; // move to next row

            // top to bottom
            for (i = r1; i < r; i++) {
                System.out.print(matrix[i][c - 1]);
            }

            c--; // reduce column boundary

            // right to left
            if (r1 < r) {
                for (i = c - 1; i >= c1; i--) {
                    System.out.print(matrix[r - 1][i]);
                }

                r--; // reduce row boundary

            }

            // bottom to top
            if (c1 < c) {
                for (i = r - 1; i >= r; i--) {
                    System.out.print(matrix[i][c1]);
                }

                c1++; // move to next col
            }

        }

    }

}