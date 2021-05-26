//Given a perfect binary tree,populate nextRight ptr for each node
// Consider tree
/* 
          5                                                
         /  \                                            
        6    7               
       / \  / \
      4  3  2  1     
          
      nextRight(6) = 7
      nextRight(4) = 3
      nextRight(3) = 2
      nextRight(1) = null
      nextRight(2) = 1

*/

public class populateNextRight {
    public static void main(Node root) {
        dfs(root, null);
    }

    private static void dfs(Node curr, Node next) {
        if (curr == null)
            return;

        curr.next = next; // set next ptr for this node

        dfs(curr.left, curr.right); // next for left child is right child of this node
        dfs(curr.right, curr.next == null ? null : curr.next.left); // next for right child is left child of parent's
                                                                    // next
    }

}
