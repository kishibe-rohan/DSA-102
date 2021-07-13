//Question Link: https://leetcode.com/problems/construct-binary-search-tree-from-postorder-traversal/

class Solution {
    public Node bstFrompostorder(int[] post) {
        int n = post.length;
        Stack<Node> st = new Stack<>();
        Node root = new Node(post[n - 1]);
        st.push(root);

        for (int i = n - 2; i >= 0; i--) {
            Node curr = new Node(post[i]);
            if (st.peek().val < curr.val)
                st.peek().right = curr;

            else {
                Node parent = new Node(st.peek());
                while (!st.isEmpty() && st.peek().val > curr.val)
                    parent = st.pop();

                parent.left = curr;

            }

            st.push(curr);
        }

        return root;
    }
}