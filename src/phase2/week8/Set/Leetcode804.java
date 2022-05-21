package phase2.week8.Set;

import java.util.TreeSet;

public class Leetcode804 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {

            StringBuffer res = new StringBuffer();
            for (int i = 0; i < word.length(); i++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString());
        }

        return set.size();
    }
}
