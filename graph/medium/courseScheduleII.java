import java.util.Queue;

//Question Link: https://leetcode.com/problems/course-schedule-ii/

public class courseScheduleII {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] order = new int[n]; // output array that consists courses in order to be taken
        int[] degree = new int[n]; // stores no. of prereqs for each course

        // stores the dependent courses for each course
        Map<Integer, List<Integer>> children = new HashMap();

        for (int i = 0; i < n; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];

            List<Integer> list = children.getOrDefault(parent, new ArrayList<Integer>());
            list.add(child);
            children.put(parent, list);

            degree[child]++;
        }

        Queue<Integer> q = new LinkedList<>(); // contains all completed courses
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0)
                q.add(i);
        }

        int completed = 0;
        while (!q.isEmpty()) {
            int course = q.remove();
            order[completed++] = course;

            if (children.containsKey(course)) {
                for (Integer child : children.get(course)) {
                    degree[child]--;
                    if (degree[child] == 0)
                        q.add(child);
                }
            }

        }

        if (completed == n)
            return order;

        return new int[0];

    }
}
