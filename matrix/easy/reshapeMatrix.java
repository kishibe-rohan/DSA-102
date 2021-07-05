//Question: Given a mxn matrix,rehape it into a r*c matrix if possible
//Else return the original matrix

public class reshapeMatrix {
    public int[][] reshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c)
            return mat;

        int[][] res = new int[r][c];

        for (int i = 0; i < r * c; i++)
            res[i / c][i % c] = mat[i / n][i % n];

        return res;

    }
}
