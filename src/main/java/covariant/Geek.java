package covariant;

public class Geek {



    public  void x(long  x){
        System.out.println("long version");
    }

    public  void x(Integer x){
        System.out.println("Primive version");
    }
    public void x(String abc){
        System.out.println("Strng version");
    }


    public static void main(String atg[]){

        byte y =1;

    new Geek().x(y);


    }


}
