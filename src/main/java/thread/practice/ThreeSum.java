package thread.practice;

import javax.print.attribute.EnumSyntax;
import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    void recur(String ar, int i) {
        if (i == 0) {
            return;
        } else {
            ar = ar + Integer.valueOf(i);
            System.out.println("Index"+i+"->"+ar);
            recur(ar, i-1);
            System.out.println("Index"+i+"->"+ar);
        }
    }

    public static void main(String[] args) {
        String a = new String("abc");
//        String a = "abc";
        new ThreeSum().recur("abcd", 3);
    }
}
