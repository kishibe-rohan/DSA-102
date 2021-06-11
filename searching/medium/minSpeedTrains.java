//Question: https://leetcode.com/problems/minimum-speed-to-arrive-on-time/

public class minSpeedTrains {
    public int minSpeed(int[] dist, double hour) {
        int n = dist.length;
        int min = 1, max = 10000000;
        int ans = -1;

        while (min <= max) {
            int mid = (min + max) / 2;
            double time = 0;
            for (int i = 0; i < n - 1; i++)
                time += Math.ceil(((double) dist[i]) / mid);

            time = time + (((double) dist[n - 1]) / mid);

            if (time > hour)
                min = mid + 1;
            else {
                ans = mid;
                max = mid - 1;
            }
        }

        return ans;
    }
}
