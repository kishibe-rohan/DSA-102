//Reverse a given stack in O(1) space

import java.util.*;

public class revStack {
    public void stackRev(Stack<Integer> s) {
        s = reverse(s);
    }

    private Stack<Integer> reverse(Stack<Integer> s) {
        // Base Case => only one element in stack or empty stack? it is already reversed
        if (s.size() == 1 || s.isEmpty())
            return s;

        // Hypothesis => remove top element and reverse the remaining stack
        int head = s.pop();
        s = reverse(s);

        // Induction => insert popped element to the end of stack
        s = insertLast(s, head);
        return s;
    }

    private static Stack<Integer> insertLast(Stack<Integer> s, int curr) {
        // Base Case => All elements popped,now add this element to end of stack
        if (s.isEmpty()) {
            s.push(curr);
            return s;
        }

        // Hypothesis => Remove the top element,insert in remaining stack
        int head = s.pop();
        s = insertLast(s, curr);

        // Induction => push the removed elements on top of stack
        s.push(head);
        return s;

    }
}
