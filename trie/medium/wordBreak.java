//Given a string s and a dictioanry of words dict
//return true if the strign can be broken into a set of words fro mthe dictionary

public static class wordBreak {

    private static class TrieNode {
        TrieNode children[];
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++)
                children[i] = null;

            isEndOfWord = false;
        }
    }

    static void insert(TrieNode root, String key) {
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();

            temp = temp.children[index];
        }

        temp.isEndOfWord = true;
    }

    static boolean search(TrieNode root, String key) {
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.children[index] == null) // search failed
                return false;

            temp = temp.children[index];
        }

        return (temp != null && temp.isEndOfWord);
    }

    public boolean wordBreakTrie(String s, String[] words) {

        // construct trie
        for (int i = 0; i < words.length; i++)
            insert(root, words[i]);

        int size = s.length();

        if (size == 0)
            return true;

        // try each prefix
        for (int i = 1; i <= size; i++)
            if (search(root, s.substring(0, i)) && wordBreakTrie(s.substring(i, size), words))
                return true;

        return false;

    }

}