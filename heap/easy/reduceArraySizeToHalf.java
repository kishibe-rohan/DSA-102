//Question Link:https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3804/

class Solution {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : arr)
            freq.put(a, freq.getOrDefault(a, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int count : freq.keySet())
            pq.offer(freq.get(count));

        int res = 0, removed = 0;
        while (!pq.isEmpty()) {
            removed += pq.poll();
            res++;
            if (removed >= (arr.length + 1) / 2)
                return res;
        }

        return arr.length;

    }
}
