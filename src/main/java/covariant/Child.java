package covariant;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

public class Child extends Parent {

    public static void main(String a[]) {


        Child plist[] = new Child[10];
        fun(plist);

        System.out.println("hello");
        funArray(new ArrayList<Child>());
    }

    public static void fun(Parent p[]) {
      //  p[0] = new AnotherChild();
        System.out.println(p);
    }
    public static void funArray(List<? extends Parent  >  plist){
      //  plist.add(new AnotherChild());

    }
}
class AnotherChild extends Parent{

}

class Parent {


}