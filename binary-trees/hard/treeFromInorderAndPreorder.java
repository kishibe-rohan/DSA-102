import java.util.HashMap;

//Construct a full binary tree given its preorder and inorder traversals

class Solution {
    private int preIndex;

    public TreeNode constructFromPreIn(int[] pre, int in[]) {
        int n = pre.length;
        preIndex = 0;
        HashMap<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < n; i++)
            inIndex.put(in[i], i);

        TreeNode root = construct(pre, in, 0, n - 1, n, inIndex);
        return root;
    }

    private TreeNode construct(int[] pre, int[] in, int lo, int hi, int n, HashMap<Integer, Integer> inIndex) {
        if (lo > hi)
            return null;

        TreeNode curr = new TreeNode(pre[preIndex]);
        if (lo == hi)
            return curr;

        int mid = inIndex.get(pre[preIndex++]);

        curr.left = construct(pre, in, lo, mid - 1, n, inIndex);
        curr.right = construct(pre, in, mid + 1, hi, n, inIndex);

        return curr;

    }
}