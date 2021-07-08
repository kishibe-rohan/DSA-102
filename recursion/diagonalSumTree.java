//Question Link: https://www.geeksforgeeks.org/diagonal-sum-binary-tree/
//Idea: Visualize as 2D matrix.In a 2D matrix,elements belonging to same diagonal have same (level - width)

class Tree {
    // keep track of sum of every diagonal
    // key = level - width
    static HashMap<Integer, Integer> sums = new HashMap();

    public static ArrayList<Integer> diagonalSum(Node root) {
        // code here.
        sums.clear();
        ArrayList<Integer> res = new ArrayList<>();
        to2DMatrix(root, 0, 0);

        for (Integer x : sums.keySet())
            res.add(sums.get(x));

        return res;
    }

    private static void to2DMatrix(Node node, int level, int width) {
        if (node == null)
            return;

        sums.put(level - width, sums.getOrDefault(level - width, 0) + node.data);

        to2DMatrix(node.left, level + 1, width - 1);
        to2DMatrix(node.right, level + 1, width + 1);
    }
}