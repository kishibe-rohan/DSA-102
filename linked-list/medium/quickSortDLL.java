//perform quicksort on a doubly linked list

public class quickSortDLL {
    public static void main(Node head) {
        Node last = findLast(head);
        quickSort(head, last);
    }

    private static Node findLast(Node head) {
        while (head.next != null)
            head = head.next;

        return head;
    }

    private static void quickSort(Node head, Node last) {
        // (start < = end)
        if (last == null || head == last || head == last.next)
            return;

        Node pivot = partition(head, last);
        quickSort(head, pivot.prev); // (start,mid-1)
        quickSort(pivot.next, last); // (mid+1,end)
    }

    private static Node partition(Node s, Node e) {
        int x = e.data; // int pivot = arr[h];
        Node i = s.prev; // i is pIndex

        for (Node j = s; j != e; j = j.next) {
            if (j.data <= x) {
                i = (i == null) ? s : i.next; // i++
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }

        i = (i == null) ? s : i.next;
        int temp = i.data;
        i.data = e.data;
        e.data = temp;

        return i;
    }
}
