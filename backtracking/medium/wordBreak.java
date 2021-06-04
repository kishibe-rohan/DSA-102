//Given a string s and list of words dict
//Add spaces in s to construct a sentence where each word is present in dict

public class wordBreak {
    public static List<String> breakWord(String s, List<String> dict) {
        List<String> res = new ArrayList<>();
        backtrack(s, dict, res, ""); // initially the sentence is empty
        return res;
    }

    private static void backtrack(String s, List<String> dict, List<String> res, String current) {
        // reached end of sentence
        if (s.length() == 0) {
            // add current sentence to final list
            res.add(current);
            return;
        }

        // check with each prefix
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);

            // check if this word is present in dict
            if (dict.contains(sub)) {
                // add it to current sentence and check for remaining string
                String newSentence = current + " " + sub;
                backtrack(s.substring(i + 1, s.length()), dict, res, newSentence.trim());
            }
        }
    }
}
