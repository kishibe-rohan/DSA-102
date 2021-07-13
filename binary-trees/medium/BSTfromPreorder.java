//Question Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

class Solution {
    public Node bstFromPreorder(int[] pre) {
        int n = pre.length;
        Stack<Node> st = new Stack<>();
        Node root = new Node(pre[0]);
        st.push(root);

        for (int i = 1; i < n; i++) {
            Node curr = new Node(pre[i]);
            if (st.peek().val > curr.val)
                st.peek().left = curr;

            else {
                Node parent = new Node(st.peek());
                while (!st.isEmpty() && st.peek().val < curr.val)
                    parent = st.pop();

                parent.right = curr;

            }

            st.push(curr);
        }

        return root;
    }
}