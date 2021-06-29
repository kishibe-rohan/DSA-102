//Question Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {

        // reverse inorder traversal
        if (root.right != null)
            bstToGst(root.right);

        root.val += sum;
        sum = root.val;

        if (root.left != null)
            bstToGst(root.left);

        return root;
    }

}
