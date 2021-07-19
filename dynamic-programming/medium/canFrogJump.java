//Question Link : https://leetcode.com/problems/frog-jump/

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (n == 0)
            return true;

        // for every stone,keep a track of the possible jump sizes from this stone
        HashMap<Integer, HashSet<Integer>> stepSizes = new HashMap<Integer, HashSet<Integer>>(n);

        for (int i = 0; i < n; i++)
            stepSizes.put(stones[i], new HashSet<Integer>());

        // 1st stone is always zero and next jump is of size 1
        stepSizes.get(0).add(1);

        for (int i = 0; i < n - 1; i++) {
            int stone = stones[i];
            for (int step : stepSizes.get(stone)) {
                // for every stone reachable from this stone

                int reach = stone + step;
                // can reach last stone from this stone in one jump
                if (reach == stones[n - 1])
                    return true;

                // add stepSizes to set of reachable stone
                HashSet<Integer> set = stepSizes.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0)
                        set.add(step - 1);
                    set.add(step + 1);
                }

            }
        }

        return false;
    }
}
