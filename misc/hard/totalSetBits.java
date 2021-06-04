class totalSetBits {

    // Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n) {

        // Your code here

        n = n + 1; // compensate for 0

        int count = 0;
        int powerOf2 = 2;

        count = n / 2; // for A,every alternate bit is set

        while (powerOf2 <= n) {
            int totalPairs = n / powerOf2; // total pairs of 0s and 1s

            count += (totalPairs / 2) * powerOf2; // (groups of 1s) x (set bits in them)

            // add remaining ones which didnt for ma total group
            count += (totalPairs % 2 == 1) ? (n % powerOf2) : 0;

            // move to next power of 2
            powerOf2 <<= 1;
        }

        return count;

    }
}