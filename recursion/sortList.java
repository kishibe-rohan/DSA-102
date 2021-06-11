
//Given a list of integers,sort it... RECURSIVELY!
import java.util.*;

public class sortList {
    public static void main(List<Integer> l) {
        l = sort(l);
    }

    private static List<Integer> sort(List<Integer> l) {
        // Base Case => If only one element is in the list,it is sorted
        if (l.size() == 1)
            return l;

        // Hypothesis => remove the last element from the array and sort the remaining
        // subarray
        int last = l.get(l.size() - 1);
        l.remove(l.size() - 1);
        l = sort(l);

        // Induction => insert the removed element in its appropriate position
        return l = insert(l, last);
    }

    private static List<Integer> insert(List<Integer> l, int last) {
        // Base Case => if the list is empty,or if the element is greater than the last
        // element of the sorted array,append it
        if (l.size() == 0 || last > l.get(l.size() - 1)) {
            l.add(last);
            return l;
        }

        // Hypothesis => remove the last(largest) element from the array
        int val = l.get(l.size() - 1);
        l.remove(l.size() - 1);
        l = insert(l, last);

        // Induction => add the removed(largest) element in the last position
        l.add(val);
        return l;

    }
}
