//Question Link: https://leetcode.com/problems/balance-a-binary-search-tree/
//idea: Inorder traverse and get the sorted list of elements,make the middle element as root and recurse for left and right halves

class Solution {
    List<TreeNode> res = new ArrayList();

    public TreeNode balanceBinarySearchTree(TreeNode root) {
        inorder(root);
        int n = res.size();
        return balance(res, 0, n - 1);
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            res.add(node);
            inorder(node.right);
        }
    }

    private TreeNode balance(List<TreeNode> res, int lo, int hi) {
        if (lo > hi)
            return null;

        int mid = (lo + hi) / 2;
        TreeNode node = res.get(mid);

        node.left = balance(res, lo, mid - 1);
        node.right = balance(res, mid + 1, hi);

        return node;
    }
}