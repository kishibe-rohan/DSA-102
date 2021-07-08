//Question Link: https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree

class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        //find LCA of both nodes
        //ans = d1 + d2
        
        
        Node lca = findLCA(root,a,b);
        int d1 = dist(lca,a,0);
        int d2 = dist(lca,b,0);
        
        return d1+d2;
    }
    
    static Node findLCA(Node node,int a,int b)
    {
        if(node==null)
        return null;
        
        if(node.data == a || node.data == b)
        return node;
        
        Node left = findLCA(node.left,a,b);
        Node right = findLCA(node.right,a,b);
        
        if(left != null && right!=null)
        return node;
        if(left == null && right == null)
        return null;
        if(left != null)
          return findLCA(node.left,a,b);
        else
          return findLCA(node.right,a,b);
    }
    
    static int dist(Node node,int num,int steps)
    {
        if(node == null)
        return -1;
        
        if(node.data == num)
        return steps;
        
        int left = dist(node.left,num,steps+1);
        if(left == -1)
        return dist(node.right,num,steps+1);
        
        return left;
        
    }
}