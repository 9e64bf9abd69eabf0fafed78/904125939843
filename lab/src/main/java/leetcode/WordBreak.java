package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date :  19.4.10  18:59
 */
public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>() {{
            add("car");
            add("ca");
            add("rs");
        }};
        String s = "cars";
      /*  List< String > wordDict = new ArrayList< String >() {{
            add( "cats" );
            add( "dog" );
            add( "sand" );
            add( "and" );
            add( "cat" );
        }};
        String s = "catsandog";*/
        System.out.println(wordBreak(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            s = s.replaceAll(word, "");
        }
        return s.length() == 0;
    }
}
