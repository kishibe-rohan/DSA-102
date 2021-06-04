//Given an integer,find the number of set bits in its binary representation

public class setBits {
    public int setBit(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1; // n&1 => n%2
            n = n >> 1; // n>>1 => n/2
        }

        return count;

    }
}
