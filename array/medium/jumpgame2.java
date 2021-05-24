public class jumpgame2 {
    public int main(String[] args) {
        int arr[] = { 2, 3, 1, 1, 4 };

        int jumps = 0;
        int lastJumpMax = 0;
        int currJumpMax = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            lastJumpMax = Math.max(currJumpMax, i + arr[i]);
            if (currJumpMax == i) {
                jumps++;
                currJumpMax = lastJumpMax;

                if (currJumpMax >= nums.length - 1)
                    break;
            }
        }

        return jumps;
    }
}
