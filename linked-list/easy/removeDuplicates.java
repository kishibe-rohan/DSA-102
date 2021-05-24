// list is sorted

public class removeDuplicates {
    private static removeDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr;
            while (temp != null && curr.val == temp.val)
                temp = temp.next;

            curr.next = temp;
            curr = curr.next;
        }

        return head;
    }
}
