import javax.lang.model.util.ElementScanner6;

public class bstInsert {
    public static void insert(Node root, int key) {
        root = insertRec(root, key);
    }

    private static Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        else if (root.value < key)
            root.left = insertRec(root.left, key);

        else
            root.right = insertRec(root.right, key);

        return root;
    }

}
