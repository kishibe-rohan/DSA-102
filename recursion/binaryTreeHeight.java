//Return the height of a binary tree 

public class binaryTreeHeight {
    public int treeHeight(Node root) {
        // base case
        if (root == null)
            return 0;

        // hypothesis
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        // induction
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
