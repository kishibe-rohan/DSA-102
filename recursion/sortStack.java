
//sort a stack recursively
import java.util.*;

public class sortStack {
    public static void main(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++)
            st.push(arr[i]);

        st = stackSort(st);
    }

    public static Stack<Integer> stackSort(Stack<Integer> s) {

        // Base Case => only one element in stack,then it is sorted
        if (s.size() == 1)
            return s;

        // Hypothesis => remove the top element and sort remaining stack
        int head = s.pop();
        s = stackSort(s);

        // Induction => Insert the popped element at its appropriate location
        return s = insert(s, head);

    }

    public static Stack<Integer> insert(Stack<Integer> s, int curr) {
        // Base Case => Empty stack or element to be inserted is larger than the head of
        // stack
        if (s.isEmpty() || curr > s.peek()) {
            s.push(curr);
            return s;
        }

        // Hypothesis => remove top element from stack and try to insert in remaining
        // stack
        int temp = s.pop();
        s = insert(s, curr);

        // Induction => put the popped element back on the top of stack
        s.push(temp);
        return s;
    }
}
