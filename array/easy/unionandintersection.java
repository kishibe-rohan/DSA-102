import java.util.HashSet;

public class unionandintersection {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        int b[] = { 1, 2, 3 };

        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> union = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            hs.add(a[i]);
            union.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            hs.add(b[i]);
            union.add(b[i]);
            if (hs.contains(b[i])) {
                intersection.add(b[i]);
            }
        }

    }
}
