//Question Link: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < pieces.length; i++)
            pos.put(pieces[i][0], i); // store the first element of every piece with its index

        for (int i = 0; i < arr.length;) {
            // this element is not available in any of the pieces
            if (!pos.containsKey(arr[i]))
                return false;

            int posPiece = pos.get(arr[i]);
            int j = 0;

            // the next elements in arr and this piece should be the same
            while (j < pieces[posPiece].length) {
                if (arr[i++] != pieces[posPiece][j++])
                    return false;
            }
        }

        return true;
    }
}
