//Same question as max tree but iterative & more efficient 
//idea is that if we already have max tree for nums [0:i-1],what ways can nums[i] be inserted to the tree

class Solution {
    public TreeNode constructMaxTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);

            // smaller elements go to the left of curr
            while (!stack.isEmpty() && stack.peek() < num)
                curr.left = stack.pop();

            if (!stack.isEmpty())
                stack.peek().right = curr;

            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }

}