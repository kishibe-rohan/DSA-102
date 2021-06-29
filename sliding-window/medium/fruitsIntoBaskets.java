//Question Link :https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> types = new HashMap<>();
        int k = 2;
        int i = 0, j;

        int ans = 0;

        for (j = 0; j < fruits.length; j++) {
            types.put(fruits[j], types.getOrDefault(fruits[j], 0) + 1);

            // if there are more than 2 types of fruits in the basket,remove all occurences
            // of a type
            while (types.size() > k) {
                types.put(fruits[i], types.get(fruits[i]) - 1);
                if (types.get(fruits[i]) == 0)
                    types.remove(fruits[i]);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;

    }
}
