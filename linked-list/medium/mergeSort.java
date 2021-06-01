//Given a singly Linked List,perform MergeSort on it
//partition() => to find the split point of list/sublist
//merge() => to merge two sorted lists recursively

public class mergeSort {
    public static Node mergeSortList(Node head) {
        // if list is of size 0 or 1
        if (head == null || head.next == null)
            return head;

        Node split[] = partition(head);
        Node firstListHead = split[0];
        Node secondListHead = split[1];

        // recurse for both sublists
        firstListHead = mergeSortList(firstListHead);
        secondListHead = mergeSortList(secondListHead);

        // merge the sorted lists
        return merge(firstListHead, secondListHead);
    }

    private static Node merge(Node a, Node b) {
        // base cases
        if (a == null)
            return b;

        if (b == null)
            return a;

        Node res;
        if (a.data <= b.data) {
            res = a;
            res.next = merge(a.next, b);
        } else {
            res = b;
            res.next = merge(a, b.next);
        }

        return res;
    }

    private static Node[] partition(Node src) {
        // if list is of size 0 or 1
        if (src == null || src.next == null)
            return new Node[] { src, null };

        // find midpoint of list
        // slow ptr-fast ptr approach

        Node slow = src;
        Node fast = src.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // slow.next points to the starting node of second list
        Node arr[] = new Node[] { src, slow.next };
        slow.next = null;

        return arr;

    }

}
