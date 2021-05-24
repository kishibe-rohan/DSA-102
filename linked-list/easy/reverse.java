public class reverse {
    public static void main(String[] args, ListNode head) {
        ListNode curr = head;
        ListNode prev = next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}