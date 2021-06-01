// Given a number reperesented in the form of a Singly Linked List
// Add 1 to the number and return the linked list
// Idea: Reverse the number,perform the operation,reverse the number again and retun
// O(N) time and O(1) space
public class add1 {
    public static Node main(Node head) {
        Node rev = reverse(head);
        Node temp = rev;
        while (temp != null) {

            // Two cases: Number <9 or Number = 9
            // stop at first non-9 value
            if (temp.val + 1 <= 9) {
                temp.val = temp.val + 1;
                break;
            } else {
                temp.val = 0;

                // last digit?
                if (temp.next == null) {
                    temp.next = new Node(1);
                    break;
                }

                temp = temp.next;
            }
        }
        return reverse(temp);
    }

    private static Node reverse(Node node) {

        if (node == null || node.next == null)
            return node;

        Node curr = node;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
