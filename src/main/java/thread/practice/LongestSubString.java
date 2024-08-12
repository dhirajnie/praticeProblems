package thread.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int globalMax = 0;
        int curMax = 0;
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (map.containsKey(key)) {
                System.out.println("Contains char:c" + key);
                curMax = curMax - map.get(key) ;
            } else {
                curMax++;
            }
            map.put(key, i);
            if (curMax < 0) {
                curMax = 0;
            }
            if (curMax > globalMax) {
                globalMax = curMax;
            }
        }
        return globalMax ;

    }


    public static void main(String[] args) {
//        System.out.println(new LongestSubString().lengthOfLongestSubstring("dvdf"));
        System.out.println(new LongestSubString().lengthOfLongestSubstring("bbabcd"));



        /*


        abcdabc


         */
    }
}
