//Given 'n' jobs
//A job can be completed only after all its pre-requisite jobs are completed
//It takes unit time to complete a job
//Return minimum time it takes to complete all the jobs
// (Similar to Course Schedule)  => Topological Sort

public class minTimeJobs {
    public static int minTime(int n, int[][] prerequisites) {
        int[] degree = new int[n];
        int[] job = new int[N]; // stores min time to complete this job

        // contains all jobs which depend on it
        Map<Integer, List<Integer>> list = new HashMap();

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];

            List<Integer> curr = children.getOrDefault(parent, new ArrayList<Integer>());
            curr.add(child);
            children.put(parent, curr);

            degree[child]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++)

        {
            if (degree[i] == 0) {
                q.add(i);
                job[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();

            if (list.containsKey(cur)) {
                for (Integer child : list.get(cur)) {
                    degree[child]--;
                    if (degree[child] == 0) {
                        q.add(child);
                        jobs[child] = jobs[cur] + 1;
                    }
                }
            }

            int res = Integer.MIN_VALUE;

            for (int j : jobs) {
                if (j > res)
                    res = j;
            }

            return res;
        }
    }
}