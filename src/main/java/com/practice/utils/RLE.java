package com.practice.utils;

public class RLE {


    String calculateRLE(String input) {

        StringBuffer output = new StringBuffer();
        int i = 0;
        while (i < input.length()) {
            int count = 1;
            int j = i + 1;
            while (j < input.length() && input.charAt(i) == input.charAt(j)) {
                ++count;
                ++j;
            }
            output.append(String.valueOf(count) + input.charAt(i));
            i = j;
        }

        return output.toString();
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return calculateRLE(countAndSay(n - 1));
        }
    }


    public static void main(String[] args) {
        System.out.println(new RLE().countAndSay(4));
//        System.out.println(new RLE().calculateRLE("1"));
//        System.out.println(new RLE().calculateRLE("11"));
//        System.out.println(new RLE().calculateRLE("222111113"));
    }
}
