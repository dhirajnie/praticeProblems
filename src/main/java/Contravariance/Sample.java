package Contravariance;

import java.util.ArrayList;
import java.util.List;

public class Sample {

    public static void main(String args[]) {

        List<Integer> list = new ArrayList<>();
        List list1 = new ArrayList<>();

        Idea i = new Idea(1);
        System.out.println(i.i);
        Idea i1 = new Idea(2.098);


    }
}

class Idea<T> {
    T i;

    public Idea(T i) {
        this.i = i;
    }
}
