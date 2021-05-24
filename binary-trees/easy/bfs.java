//print level order traversal of a binary tree
/*
class Node{
    int data;
    Node left,right;
}

*/

public class bfs {
    public static void main(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.println(curr.data);

            if (curr.left != null)
                q.add(curr.left);

            if (curr.right != null)
                q.add(curr.right);
        }

        return;
    }
}
