public class bstSearch {
    public static Node search(Node root, int key) {
        if (root.value == key)
            return root;

        else if (root.value > key)
            return search(root.left, key);

        else
            return search(root.right, key);
    }

}
