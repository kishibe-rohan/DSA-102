
//Given a string return all its subsets
import java.util.*;

public class subsets {
    static final List<String> res = new ArrayList<String>();

    public List<String> main(String s) {
        solve(s, 0, " ");
        return res;
    }

    private static void solve(String ip, int i, String op) {

        // base case
        int n = ip.length();
        if (i == n) {
            res.add(op);
            return;
        }

        solve(ip, i + 1, op + ip.charAt(i)); // include current character
        solve(ip, i + 1, op); // dont include current character
    }

}
