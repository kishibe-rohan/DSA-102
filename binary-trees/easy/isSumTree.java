//Question Link: https://practice.geeksforgeeks.org/problems/sum-tree

class Solution {
    static boolean ans;

    boolean isSumTree(Node root) {
        // Your code here
        if (root == null || (root.left == null && root.right == null))
            return true;

        // get sum of left and right subtrees
        int left = sum(root.left);
        int right = sum(root.right);

        if ((root.data == left + right) && isSumTree(root.left) && isSumTree(root.right))
            return true;

        return false;
    }

    static int sum(Node node) {
        if (node == null)
            return 0;

        // get sum of left and right subtrees
        int left = sum(node.left);
        int right = sum(node.right);

        return left + right + node.data;
    }

}
