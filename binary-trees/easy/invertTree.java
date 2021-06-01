//Given a binary tree,invert it
//Both recursive and iterative

public class invertTree {
    public static void main(Node root) {
        invertDFS(root);
        // invertBFS(root);
        return;
    }

    private static Node invertDFS(Node root) {
        // base case
        if (root == null)
            return null;

        // recur for left and right subtrees
        Node l = invertDFS(root.left);
        Node r = invertDFS(root.right);

        // swap left and right subtrees
        root.left = r;
        root.right = l;

        return root;
    }

    private static Node invertBFS(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            // get current node
            Node curr = q.poll();

            // swap its left and right childrem
            Node temp = q.left;
            q.left = q.right;
            q.right = temp;

            // add children to queue
            if (q.left != null)
                q.add(q.left);
            if (q.right != null)
                q.add(q.right);
        }

        return root;
    }
}
