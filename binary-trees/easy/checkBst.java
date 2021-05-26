//confirm if given tree is BST or not
//keep a track of max and min values
//every value in left subtree must be less than the root(max)
//every value in right subtree must be more than root(min)

public class checkBst {
    public static boolean main(Node root) {
        return isBST(root, null, null);
    }

    private static boolean isBST(Node root, Node min, Node max) {

        // Base Case
        if (root == null)
            return true;

        // check constraints for current node
        if (min != null && root.key <= min.key)
            return false;

        if (max != null && root.key >= max.key)
            return false;

        // recur for left and right subtrees
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}
