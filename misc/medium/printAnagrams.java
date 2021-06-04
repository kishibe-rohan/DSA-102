//Question Link: https://leetcode.com/problems/group-anagrams/

class printAnagrams {

    public List<List<String>> Anagrams(String[] strs) {

        if (strs.length == 0)
            return new ArrayList();

        HashMap<String, List> lists = new HashMap(); // anagram group -> words in group
        int[] freq = new int[26]; // char frequency count for words

        for (String s : strs) {
            Arrays.fill(freq, 0);

            // get frequency count
            for (char c : s.toCharArray())
                freq[c - 'a']++;

            // encode
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(freq[i]);
            }

            String key = sb.toString();
            if (!lists.containsKey(key))
                lists.put(key, new ArrayList());

            lists.get(key).add(s);
        }

        return new ArrayList(lists.values());
    }

}
