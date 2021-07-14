//Serialize and Deserialize a Binary Tree

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null)
            sb.append("#").append(",");
        else {
            sb.append(node.val);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        String s = q.poll();
        if (s.equals('#'))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(q);
        root.right = deserialize(q);

        return root;
    }
}
