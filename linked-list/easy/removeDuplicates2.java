import java.util.HashSet;

public class removeDuplicates2 {
    private void removeDuplicates2(ListNode head) {
        ListNode curr = head, pre = null;
        HashSet<Integer> hs = new HashSet<>();

        while (curr != null) {
            int val = curr.val;

            // already seen
            if (hs.contains(val)) {
                prev.next = curr.next;
            } else {
                hs.add(val);
                prev = curr;
            }

            curr = curr.next;
        }
    }
}
