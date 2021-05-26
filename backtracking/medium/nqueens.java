//For a NxN chess board
//return all valid N-queen configurations

public class nqueens {
    public static List<List<String>> main(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        // initlaize empty board
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        solve(board, res, n, 0);
        return res;
    }

    private static void solve(char[][] board, List<List<String>> res, int n, int col) {

        // found a valid configuration..add to result
        if (col == n) {
            res.add(configure(board));
            return;
        }

        // try to place queen on valid rows for this column
        for (int i = 0; i < n; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q'; // visit
                solve(board, res, n, col + 1); // check if this leads to a valid configuration
                board[i][col] = '.'; // unvisit/backtrack
            }
        }

        return;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        // check this row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q')
                return false;
        }

        // check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // check right diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    private static List<String> configure(char[][] board) {
        List<String> curr = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            curr.add(row);
        }

        return curr;
    }
}
