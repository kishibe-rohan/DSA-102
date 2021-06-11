//https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/

public class towerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // number of disks (no. of moves = 2^n - 1)
        solve(n, 'A', 'B', 'C');
    }

    private static void solve(int n, char src, char helper, char dest) {

        // base case => only 1 disc left to transfer to dest
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + src + " to rod " + dest);
            return;
        }

        // hypothesis => move n-1 discs from src to helper
        solve(n - 1, src, dest, helper);
        System.out.println("Move disk " + n + " from rod " + src + " to rod " + dest);

        // induction
        solve(n - 1, helper, dest, src);

    }
}
