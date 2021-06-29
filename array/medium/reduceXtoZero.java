//Question Link: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3603

class Solution {

    // find max length subarray with sum = totalSum - x;
    public int minOperations(int[] nums, int x) {
        int target = 0;
        for (int num : nums)
            target += num;

        target -= x;
        if (target == 0)
            return nums.length;

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target))
                res = Math.max(res, i - map.get(sum - target));

            map.put(sum, i);
        }

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}
