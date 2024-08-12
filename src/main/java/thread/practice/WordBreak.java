package thread.practice;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    Map<String, Boolean> map = new HashMap<>();

    public boolean findMatch(int startIndex, String currentStr, String s, Set<String> words) {
        System.out.print("startIndex,:" + startIndex + " currentStr:" + currentStr);
        if (startIndex >= s.length()) {
            return false;
        } else if (map.containsKey(currentStr)) {
            System.out.println("From map");
            return map.get(currentStr);
        } else {
            boolean fullSeach = false;
            for (int i = startIndex; i < s.length() && fullSeach != true; i++) {
                currentStr = currentStr + s.charAt(i);
                System.out.println("index:" + i);
                if (words.contains(currentStr.toString())) {
                    if (i == s.length() - 1) {
                        //full match
                        fullSeach = true;
                        break;
                    }
                    while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                        ++i;
                    }
                    fullSeach = findMatch(i + 1, new String(), s, words) ||
                            findMatch(i + 1, currentStr, s, words);
                }
            }
            map.put(currentStr, fullSeach);
            System.out.println(" return fullSeach:" + fullSeach);
            return fullSeach;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {


        Set<String> wordSet = wordDict.stream().collect(Collectors.toSet());

        return findMatch(0, new String(), s, wordSet);

    }


    public static void main(String[] args) {
        String wordsstrtr[] = {"abbcbda", "cbdaaa", "b", "dadaaad", "dccbbbc", "dccadd", "ccbdbc",
                "bbca", "bacbcdd", "a", "bacb", "cbc", "adc", "c", "cbdbcad", "cdbab", "db", "abbcdbd", "bcb", "bbdab", "aa", "bcadb", "bacbcb", "ca", "dbdabdb", "ccd", "acbb", "bdc", "acbccd", "d", "cccdcda", "dcbd", "cbccacd", "ac", "cca", "aaddc", "dccac", "ccdc", "bbbbcda", "ba", "adbcadb", "dca", "abd", "bdbb", "ddadbad", "badb", "ab", "aaaaa", "acba", "abbb"};
        List<String> words = new ArrayList<>();
      for(int i=0;i<wordsstrtr.length;i++){
          words.add(wordsstrtr[i]);
      }

//                {"leet","code"};

        System.out.println(new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", words));
    }
}
