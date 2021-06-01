//For a binary tree,return sum of the longest path from root to a leaf node
//if there are multiple contenders for max path length,return the one with max sum 

public class rootToLeafSum {

    static int maxSum;
    static int maxHeight;

    public static int main(Node root) {
        if (root == null)
            return 0;

        maxSum = Integer.MIN_VALUE;
        maxHeight = 0;

        dfs(root, 0, 0);
        return maxSum;
    }

    private static void dfs(Node node, int sum, int height) {
        // reached end of path
        if (node == null) {
            // found new longest path
            if (height > maxHeight) {
                maxHeight = height;
                maxSum = sum;
            }

            // same height as other paths
            else if (height == maxHeight) {
                maxSum = Math.max(maxSum, sum);
            }

            return;
        }

        // recur for left and right subtrees
        dfs(node.left, sum + node.val, height + 1);
        dfs(node.right, sum + node.val, height + 1);
    }
}
