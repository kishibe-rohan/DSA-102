//Question Link: https://www.facebook.com/codingcompetitions/hacker-cup/2020/qualification-round/problems/A

public class travelRestrictions {
    public void travel(char[] in, char[] out) {
        int n = in.length;

        char[][] res = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean possible = true;
                if (i <= j) {
                    for (int k = i; k < j; k++) {
                        if (out[k] != 'Y' || in[k + 1] != 'Y')
                            possible = false;
                    }
                } else {
                    for (int k = i; k < j; k--) {
                        if (out[k] != 'Y' || in[k - 1] != 'Y')
                            possible = false;

                    }
                }

                res[i][j] = possible ? 'Y' : 'N';
            }
        }
    }
}
