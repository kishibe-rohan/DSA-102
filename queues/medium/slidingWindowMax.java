import java.util.Deque;

//Question Link: https://leetcode.com/problems/sliding-window-maximum
//Idea: Use a deque to keep track of max element for each window
//Head of queue stores the index of max
//if its index is out of current window,we remove it from queue
//before inserting an  element in queue,we remove all elements smaller than it

public class slidingWindowMax {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0)
            return new int[0];

        int n = a.length;
        int[] res = new int[n - k + 1];
        int resIndex = 0;

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove elements out of window
            while (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();

            // remove smaller elements before adding current
            while (!q.isEmpty() && a[q.peekLast()] < a[i])
                q.pollLast();

            // add current index to queue
            q.offer(i);

            if (i >= k - 1)
                res[resIndex++] = a[q.peek()]; // head of queue is max for this window
        }

        return res;
    }
}
