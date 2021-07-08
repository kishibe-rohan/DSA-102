//Question Link : https://leetcode.com/problems/house-robber-iii/

class Solution {

    public int rob(TreeNode root) {
        // ans[0] = max value upon include,ans[1] = max value upon excluding current
        // node
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };

        // get the values from left and right subtrees
        int left[] = helper(node.left);
        int right[] = helper(node.right);

        int include = node.val + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { include, exclude };
    }

}