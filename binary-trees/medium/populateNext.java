//populate 'next' ptr for all nodes in a bianry tree
//with their inorder successors

//Idea: Do a reverse inorder traversal (R-N-L)
//remember previously seen node

public class populateNext {
    static Node next = null;

    public static void populate(Node root) {
        if (root != null) {
            populate(root.right);
            root.next = next;
            next = root;
            populate(root.left);
        }
    }
}
