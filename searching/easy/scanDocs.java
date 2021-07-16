//Geek wants to scan N documents using two scanners. If S1 and S2 are the time taken by the scanner 1 and scanner 2 to scan a single document, find the minimum time required to scan all the N documents.

class Solution {
    static int minTime(int S1, int S2, int N) {
        // code here
        // max time needed will be max(S1,S2) * N
        int lo = 1;
        int hi = N * (Math.max(S1, S2));

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int docs = helper(S1, S2, mid); // number of docs scanned in 'mid' seconds

            if (docs < N)
                lo = mid + 1;

            else
                hi = mid;
        }

        return hi;
    }

    static int helper(int S1, int S2, int t) {
        int docs = (t / S1) + (t / S2);
        return docs;
    }
}