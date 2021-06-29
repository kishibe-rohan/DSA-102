//Question Link : https://leetcode.com/problems/delete-leaves-with-a-given-value
//Approach: Postorder traversal

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null)
            root.left = removeLeafNodes(root.left, target);
        if (root.right != null)
            root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null)
            root = null;

        return root;
    }
}