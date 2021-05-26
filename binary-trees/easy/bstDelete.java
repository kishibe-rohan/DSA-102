import org.w3c.dom.Node;

public class bstDelete {
    public static void delete(Node root, int key) {
        root = deleteRec(root, key);
    }

    private static Node deleteRec(Node root, int key) {
        // Base Case: Empty Tree
        if (root == null) {
            return root;
        }

        // recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);

        else if (root.key < key)
            root.right = deleteRec(root.right, key);

        // found the node
        else {
            // only has right child
            if (root.left == null)
                return root.right;

            // only has left child
            else if (root.right == null)
                return root.left;

            // has both children?
            // find key of inorder successor and make it the key of mode to be deleted
            root.key = minVal(root.right);

            // delete inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minVal(int root) {
        int minval = root.key;

        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }

        return minval;
    }

}
