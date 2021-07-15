// Construct a full binary tree given the preorder traversal of itself and its
// mirror tree
/*
Consider the tree
                      1
                     / \
                    2   3
                   /\   /\ 
                  4  5 6  7

                  pre[]  = (1,2,4,5,3,6,7)
                  preMirror[] = {1,3,7,6,2,5,4}

                  root will be pre[0] and the next element after it in pre i.e. pre[1] will be root.left
                  and every element to the right of 2 in preMirror[] will be in left subtree
                  and similarly the element after 1 in preMirror and before 2 will be its right subtree
                  Construct the tree recursively ( refer treeFromPreAndPost Q.)
*/

class Solution {
    private int preIndex;

    public TreeNode constructFromPreMirror(int[] pre, int[] preMirror) {
        int n = pre.length;
        preIndex = 0;
        HashMap<Integer, Integer> mirrorIndex = new HashMap<>();
        for (int i = 0; i < n; i++)
            mirrorIndex.put(preMirror[i], i);

        TreeNode root = construct(pre, preMirror, 0, n - 1, n, mirrorIndex);
        return root;
    }

    private TreeNode construct(int[] pre, int[] mirror, int l, int h, int n, HashMap<Integer, Integer> mirrorIndex) {
        if (l > h)
            return null;

        TreeNode curr = new TreeNode(pre[preIndex++]);
        if (lo == hi)
            return curr;

        int mid = mirrorIndex.get(pre[preIndex]);
        curr.left = construct(pre, mirror, mid, h, n, mirrorIndex);
        curr.right = construct(pre, mirror, l + 1, mid - 1, n, mirrorIndex);

        return curr;
    }
}