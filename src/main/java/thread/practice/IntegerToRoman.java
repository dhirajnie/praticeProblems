package thread.practice;

import java.util.SortedMap;
import java.util.TreeMap;

public class IntegerToRoman {


    TreeMap<Integer, String> getBasicUnitMap() {
        TreeMap<Integer, String> map = new TreeMap();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "LC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        return map;
    }

    public String intToRoman(int num) {
        TreeMap<Integer, String> map = getBasicUnitMap();
        StringBuffer output = new StringBuffer();
        while (num > 0) {
            Integer offset = 0;
            if (map.containsKey(num)) {
                offset = num;
            } else {
                offset = map.headMap(num).lastKey();
            }
            System.out.println("Number:" + num);
            num = num - offset;
            output.append(map.get(offset));
        }
        return output.toString();
    }


    public static void main(String[] args) {
//        System.out.println(new IntegerToRoman().intToRoman(3749));
        SortedMap<Integer,String > sortedMap = new IntegerToRoman().getBasicUnitMap();
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.headMap(2));
    }
}
