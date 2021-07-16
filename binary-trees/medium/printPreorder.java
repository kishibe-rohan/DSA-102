//Question Link:https://www.geeksforgeeks.org/preorder-from-inorder-and-postorder-traversals/
//Given inorder and postorder traversals of a binary tree,print its preorder traversal

class Solution {
    private int postIndex;

    public void printPre(int[] in, int[] post) {
        int n = in.length;
        postIndex = n - 1;
        HashMap<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < n; i++)
            inIndex.put(in[i], i);

        Stack<Integer> s = new Stack<>();
        fillPre(in, post, 0, n - 1, s, inIndex);

        while (!s.isEmpty())
            System.out.print(s.pop() + " ");
    }

    private void fillPre(int[] in, int[] post, int lo, int hi, Stack<Integer> s, HashMap<Integer, Integer> inIndex) {
        if (lo > hi)
            return;

        // last element in postOrder is root
        int curr = post[postIndex];
        postIndex--;
        int idx = inIndex.get(curr);

        // recur for right and left subtrees
        fillPre(in, post, idx + 1, hi, s, inIndex);
        fillPre(in, post, lo, idx, s, inIndex);

        s.push(curr);
    }
}
