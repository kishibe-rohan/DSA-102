class movenegatives {
    public static void main(String[] args) {
        int a[] = { 10, -9, 1, -3, -2 };
        int n = a.length;
        // rearrange1(a,n); //Approach 1
        rearrange2(a, n); // Approach 2
    }

    private static void rearrange1(int[] arr, int n) {
        int j = 0, temp;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

                j++;
            }
        }
    }

    private static void rearrange2(int[] arr, int n) {
        int left = 0, right = n - 1;
        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0)
                left++;

            else if (arr[left] > 0 & arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            else if (arr[left] > 0 && arr[right] > 0)
                right--;

            else {
                left++;
                right--;
            }
        }
    }
}