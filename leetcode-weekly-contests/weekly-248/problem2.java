//Question Link: https://leetcode.com/contest/weekly-contest-248/problems/eliminate-maximum-number-of-monsters/

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {

        // sort based on time of arrival

        int i;
        for (i = 0; i < dist.length; i++)
            dist[i] = (int) Math.ceil((double) dist[i] / speed[i]);

        Arrays.sort(dist);

        for (i = 0; i < dist.length && dist[i] > i; i++)
            ;

        return i;

    }
}
