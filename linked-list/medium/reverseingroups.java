public class reverseingroups {
    public static ListNode main(String[] args, ListNode head, int k) {
        // ListNode res = reverse1(head,k);
        ListNode res = reverse2(head, k);

        return res;
    }

    private static ListNode reverse1(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;

        Stack<ListNode> stack = new Stack<ListNode>();

        while (curr != null) {
            int count = 0;
            while (curr != null && count < k) {

                stack.push(curr);
                curr = curr.next;
                count++;
            }

            while (stack.size() > 0) {
                // first time?
                if (prev == null) {
                    prev = stack.peek();
                    head = prev;
                    stack.pop();
                } else {
                    prev.next = stack.peek();
                    prev = prev.next;
                    stack.pop();
                }

            }

        }

        prev.next = null;
        return head;
    }

    private static ListNode reverse2(ListNode head, int k) {

        // recursive implementation
        if (head == null)
            return null;

        ListNode curr = head;
        ListNode prev = next = null;

        int cnt = 0;

        while (curr != null && cnt < k) {
            // logic to reverse Linked List
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        // recursively call for remaining list
        if (next != null)
            head.next = reverse2(next, k);

        return prev;
    }
}
