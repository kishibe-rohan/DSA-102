public class jumpgame {
    public boolean main(String[] args) {
        int arr[] = { 9, 4, 2, 1, 0, 2, 0 };

        int target = arr.length;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i + arr[i] >= target)
                target = i;
        }

        return target == 0;

    }
}
