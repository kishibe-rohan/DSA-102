//Question Link: https://leetcode.com/problems/maximum-binary-tree

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = constructMax(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode constructMax(int[] nums, int i, int j) {
        if (i > j || i < 0 || j > nums.length - 1)
            return null;

        if (i == j)
            return new TreeNode(nums[i]);

        int k;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (k = i; k <= j; k++) {
            if (nums[k] > max) {
                max = nums[k];
                maxIndex = k;
            }
        }

        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructMax(nums, i, maxIndex - 1);
        node.right = constructMax(nums, maxIndex + 1, j);

        return node;
    }
}