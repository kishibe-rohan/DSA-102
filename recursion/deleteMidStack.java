//Given a stack,delete its middle element

import java.util.*;

public class deleteMidStack {
    public static Stack<Integer> main(Stack<Integer> st) {

        if (st.size() == 0)
            return st;

        int k = Math.floorDiv(st.size(), 2) + 1;
        st = deleteMiddle(st, k);

        return st;
    }

    private static Stack<Integer> deleteMiddle(Stack<Integer> s, int k) {
        // Base Case => middle element has been propagated to top of stack
        if (k == 1) {
            s.pop();
            return s;
        }

        // Hypothesis => Remove head of stack and reduce k by 1 i.e. push middle element
        // up
        int head = s.pop();
        s = deleteMiddle(s, k - 1);

        // Induction => Push back the popped element to top of stack
        s.push(head);
        return s;

    }

}
