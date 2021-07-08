
//Question Link: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree
//Idea: Print the bottom-most node for every horizontal distance. HD(root) = 0,HD(root.left) = -1,HD(root.right) = 1;
import java.util.*;

class Tree {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        int hd = 0;
        root.hd = 0;

        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            hd = curr.hd;

            map.put(hd, curr.data);
            if (curr.left != null) {
                curr.left.hd = hd - 1;
                q.add(curr.left);
            }

            if (curr.right != null) {
                curr.right.hd = hd + 1;
                q.add(curr.right);
            }
        }

        for (Integer dist : map.keySet())
            res.add(map.get(dist));

        return res;

    }
}