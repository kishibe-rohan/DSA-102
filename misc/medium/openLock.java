//Question Link: https://leetcode.com/problems/open-the-lock/

class openLock {
    public int open(String[] deadends, String target) {

        // BFS

        int moves = 0;

        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);

        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        // add starting point to q
        q.offer("0000");
        if (deads.contains("0000"))
            return -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.remove();

                // found target
                if (curr.equals(target))
                    return moves;

                // check all moves from this position
                for (int j = 0; j < 4; j++) {
                    char c = curr.charAt(j);

                    // add 1
                    String s1 = curr.substring(0, j) + (c != '9' ? (char) (c + 1) : '0') + curr.substring(j + 1);

                    // subtract 1
                    String s2 = curr.substring(0, j) + (c != '0' ? (char) (c - 1) : '9') + curr.substring(j + 1);

                    if (!vis.contains(s1) && !deads.contains(s1)) {
                        q.add(s1);
                        vis.add(s1);
                    }

                    if (!vis.contains(s2) && !deads.contains(s2)) {
                        q.add(s2);
                        vis.add(s2);
                    }

                }

            }

            moves++;
        }

        return -1;
    }
}