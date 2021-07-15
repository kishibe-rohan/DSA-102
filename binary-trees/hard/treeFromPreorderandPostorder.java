//Construct a full binary tree from its preorder and postorder traversals

class Solution {
    private int preIndex;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        preIndex = 0;
        HashMap<Integer, Integer> postIndex = new HashMap<>();
        for (int i = 0; i < n; i++)
            postIndex.put(post[i], i);

        TreeNode root = construct(pre, post, 0, n - 1, n, postIndex);
        return root;
    }

    private TreeNode construct(int[] pre, int[] post, int lo, int hi, int n, HashMap<Integer, Integer> postIndex) {
        // base case
        if (lo > hi)
            return null;

        // first node in preorder traversal is the root
        TreeNode curr = new TreeNode(pre[preIndex++]);
        if (lo == hi)
            return curr; // only one node in current subtree

        // get the postIndex of the next element in preorder[]
        // all elements to the left of this belong in the left subtree
        // remaining belong in the right subtree
        int mid = postIndex.get(pre[preIndex]);

        curr.left = construct(pre, post, lo, mid, n, postIndex);
        curr.right = construct(pre, post, mid + 1, hi - 1, n, postIndex);

        return curr;
    }
}
