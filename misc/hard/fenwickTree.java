
//Implement update(),getSum() and constructTree() functiosn for a Bianry Indexed Tree/Fenwick Tree
import java.util.*;

public class fenwickTree {
    final static int SIZE = 1000; // max tree size
    static int BIT[] = new int[SIZE];

    // get sum of elements in the range [0...i];
    // parent(i) = i - (i & (-i))
    // Time Complexity => O(logn)
    int getSum(int i) {
        int sum = 0;
        i = i + 1; // to account for dummy node
        while (i > 0) {
            sum += BIT[i];
            i -= i & (-i);
        }

        return sum;
    }

    // Note: update() only updates the ancestral nodes in BIT and not the acutal
    // array
    // Time Complexity => O(logn)
    void update(int n, int i, int val) {
        i = i + 1;
        while (i <= n) {
            BIT[i] += val;
            i += i & (-i);
        }
    }

    // Time Complexity => O(nlogn)
    void constructTree(int arr[], int n) {
        // initilalize
        for (int i = 1; i <= n; i++)
            BIT[i] = 0;

        // construct by update
        for (int i = 0; i < n; i++)
            update(n, i, arr[i]);
    }
}
