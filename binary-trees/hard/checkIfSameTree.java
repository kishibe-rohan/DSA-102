//Given inorder,preorder and postorder traversals of a binary tree
//Check if they belong to the same tree
//O(1) space

class Solution {
    public boolean sameTree(int[] pre, int[] post, int[] in) {
        int n = in.length;
        int s = 0, s1 = 0, s2 = 0;
        return sameTreeUtil(pre, post, in, s, s1, s2, n);
    }

    private boolean sameTreeUtil(int[] pre, int[] post, int[] in, int s, int s1, int s2, int n) {
        if (n == 0)
            return true;

        // base case
        if (n == 1)
            return (pre[s] == post[s2] && post[s2] == in[s1]);

        // first element in preorder will be root
        // elements to left of index of root in inorder will be in left subtree
        int idx = -1;
        for (int i = s1; i < s1 + n; i++) {
            if (in[i] == pre[s]) {
                idx = i;
                break;
            }
        }

        if (idx == -1)
            return false;

        idx = idx - s1;

        // recur for left and right subtrees
        boolean left = sameTreeUtil(pre, post, in, s + 1, s1, s2, idx);
        boolean right = sameTreeUtil(pre, post, in, s + 1 + idx, s1 + 1 + idx, s2 + idx, n - idx - 1);

        return left && right;

    }
}