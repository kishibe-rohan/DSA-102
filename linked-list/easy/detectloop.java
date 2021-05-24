public class detectloop {
    public static boolean main(String[] args, ListNode head) {
        // boolean ans = detect1(head);
        boolean ans = detect2(head);

        return ans;
    }

    private static boolean detect1(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }

    private static boolean detect2(ListNode head) {
        ListNode curr = head, prev = head;
        while (curr != null && curr.next != null) {
            if (curr.next == head)
                return true;
            curr = curr.next;
            prev.next = head;
            prev = curr;
        }

        return false;
    }
}
