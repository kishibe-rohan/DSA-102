//Given a BST and two nodes with values n1 and n2
//return their LCA(Lowest Common Ancestor)
//Idea : 
//Case 1: both n1 and n2 < root ? search in left subtree
//Case 2: both n1 and n2 > root ? search in right subtree
//Case 3: n1 > root and n2< root or vice versa? root is the LCA! 

public class bstLca {
    public static Node LCA(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (node.data > n1 && node.data > n2)
            return LCA(node.left, n1, n2);

        if (node.data < n1 && node.data < n2)
            return LCA(node.right, n1, n2);

        return node;

    }
}
