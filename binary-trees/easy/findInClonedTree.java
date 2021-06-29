//Question Link: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3590

class Solution {
    TreeNode ans;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(original, cloned, target);
        return ans;
    }

    private void inorder(TreeNode o, TreeNode c, TreeNode target) {
        if (o != null) {
            inorder(o.left, c.left, target);
            if (o == target)
                ans = c;
            inorder(o.right, c.right, target);
        }
    }
}
