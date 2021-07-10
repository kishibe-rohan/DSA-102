//Question Link: https://practice.geeksforgeeks.org/problems/k-distance-from-root

class Tree {
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            // reached desired level
            if (dist == k) {
                for (int i = 0; i < size; i++)
                    res.add(q.poll().data);

                return res;
            } else {
                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    if (curr.left != null)
                        q.offer(curr.left);
                    if (curr.right != null)
                        q.offer(curr.right);
                }
            }

            dist++;
        }

        return res;
    }
}