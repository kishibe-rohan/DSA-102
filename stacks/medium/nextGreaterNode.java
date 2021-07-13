//Question Link:  https://leetcode.com/problems/next-greater-node-in-linked-list

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {

        int n = 0;
        ListNode temp = head;

        // get the size of the linked list
        while (temp != null) {
            temp = temp.next;
            n++;
        }

        if (n == 0)
            return new int[] {};

        int[] store = new int[n]; // to store the values of the nodes
        int[] res = new int[n]; // to store next greater element of each node
        Deque<Integer> st = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // get the current value and store it in array
            int currVal = head.val;
            store[i] = currVal;

            // for all the previously seen elements smaller than curr
            while (!st.isEmpty() && currVal > store[st.peek()])
                res[st.pop()] = currVal;

            st.push(i);
            head = head.next;
        }

        return res;

    }
}