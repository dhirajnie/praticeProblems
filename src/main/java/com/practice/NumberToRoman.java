package com.practice;

import java.util.SortedMap;
import java.util.TreeMap;

public class NumberToRoman {

    SortedMap map = new TreeMap();
    NumberToRoman(){
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(000,"M");
    }

    public static void main(String[] args) {

    }
}
