//Question Link: https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/

import java.util.*;

public class maxCandies {
    public int maximumCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        boolean[] visited = new boolean[n];
        boolean[] foundBoxes = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        // add all available boxes to queue
        for (int box : initialBoxes) {
            q.add(box);
            foundBoxes[box] = true;
        }

        int totalCandies = 0;

        while (!q.isEmpty()) {
            // get an available box
            int curr = q.poll();

            // check if we have a key for it/is open and take candies from it
            if (status[curr] == 1 && !visited[curr]) {
                visited[curr] = true;
                totalCandies += candies[curr];
            }

            // obtain all keys from this box
            for (int k : keys[curr]) {

                // already in queue,dont duplicate
                if (status[k] == 1 && foundBoxes[k] == true)
                    continue;

                status[k] = 1; // make status as open

                if (foundBoxes[k] && !visited[k]) // box was already in found boxes but we didnt have key yet
                    q.add(k);
            }

            // for all contained boxes,add them to queue
            for (int k : containedBoxes[curr]) {
                foundBoxes[k] = true;
                q.add(k);
            }
        }

        return totalCandies;
    }
}
