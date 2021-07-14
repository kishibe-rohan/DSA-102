//Question Link: https://leetcode.com/problems/recover-binary-search-tree/

class Solution {
    // find two nodes not in ascending order in inorder traversal
    Node first;
    Node second;
    Node prev;

    public void recover(Node root) {
        if (root == null)
            return;

        first = null;
        second = null;
        prev = null;
        inorder(root);

        // swap both the nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(Node node) {
        // perfrom an inorder traversal and find the two nodes
        // for which prev.val >= curr.val
        if (root == null)
            return;

        inorder(node.left);
        if (first == null && (prev == null || prev.val >= node.val))
            first = prev;

        if (first != null && prev.val >= node.val)
            second = node;

        prev = node;

        inorder(node.right);
    }
}