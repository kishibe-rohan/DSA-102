//Question Link:https://leetcode.com/problems/course-schedule/

public class courseSchedule {
    public boolean canComplete(int n, int[][] prerequisites) {
        // detect cycle in a graph

        // stores the courses for which this course is prerequisite
        ArrayList<Integer>[] preReqs = new ArrayList[n];

        // stores number of prerequisites for each course
        int[] degree = new int[n];

        ArrayList<Integer> completed = new ArrayList<>();

        for (int i = 0; i < n; i++)
            preReqs[i] = new ArrayList<Integer>();

        for (int[] pre : prerequisites) {
            preReqs[pre[1]].add(pre[0]); // add dependent course to list
            degree[pre[0]]++; // increment no. of prereqs
        }

        for (int i = 0; i < n; i++)
            if (degree[i] == 0)
                completed.add(i);

        for (int i = 0; i < completed.size(); i++) {
            // for all courses that have this prerequisite
            for (int j : prerequisites[completed.get(i)]) {
                // remove this preprequisite
                if (--degree[j] == 0)
                    completed.add(j);
            }
        }

        return completed.size() == n;

    }
}
