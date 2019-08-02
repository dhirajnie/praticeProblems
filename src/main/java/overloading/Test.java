package overloading;

public class Test extends Parent
{

    void fun(Test t){
        System.out.println("child class ");
    }

    public static void main(String arh[]){

        Test t = new Test();
        Parent p = new Test();

        t.fun(p);

    }

}
class Parent{
    void fun(Parent a){
        System.out.println("parent class ");
    }
}
