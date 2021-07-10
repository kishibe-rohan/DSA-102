//Question Link: https://practice.geeksforgeeks.org/problems/frequency-game

class Geeks {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        int res = -1;
        int min_freq = n + 1;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            // get frequency of current number
            int fre = freq.getOrDefault(num, 0) + 1;

            // update minimum frequency is needed
            min_freq = Math.min(min_freq, fre);

            // if this number has min_freq,check if it is the largest among them and update
            if (fre == min_freq)
                res = Math.max(res, num);

            freq.put(num, fre);
        }

        return res;

    }
}