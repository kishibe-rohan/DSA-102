//Question Link: https://practice.geeksforgeeks.org/problems/print-nodes-having-k-leaves/

class Solution {
    public ArrayList<Integer> btWithKleaves(Node root, int k) {
        // add code here.
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, k, res);
        if (res.size() == 0)
            res.add(-1);

        return res;
    }

    private static int dfs(Node node, int k, ArrayList<Integer> res) {
        if (node == null)
            return 0;

        // found a leaf node,add to count
        if (node.left == null && node.right == null)
            return 1;

        // get count from elft and right subtrees
        int left = dfs(node.left, k, res);
        int right = dfs(node.right, k, res);

        // add to final list if condition is satisfied
        if (left + right == k)
            res.add(node.data);

        return left + right;
    }
}