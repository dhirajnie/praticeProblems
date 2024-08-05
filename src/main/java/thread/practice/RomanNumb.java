package thread.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanNumb {
    Map<Character, Integer> romanMap = new HashMap<>();

    RomanNumb() {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToInt(String s) {

        int num=0;
        for(int i =0;i<s.length();i++){
            if(i==s.length()-1 || romanMap.get(s.charAt(i))>=romanMap.get(s.charAt(i+1))){
                num +=romanMap.get(s.charAt(i));
            }
            else{
                num -=romanMap.get(s.charAt(i));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String inp = "XXXIX";
        System.out.println(new RomanNumb().romanToInt(inp));
    }


}
