package LLD.decorator;

import java.io.FileInputStream;

public class Demo {


    public static void main(String[] args) {
        // Creating base of the coffee
//        FileInputStream
        Beverage espresso = new Espresso();
        Beverage beveragewithMocha = new Mocha(espresso);
        Beverage  beveragewithMochaAnotherMocha = new Mocha(beveragewithMocha);
        System.out.println(beveragewithMochaAnotherMocha.cost());
        System.out.println(beveragewithMochaAnotherMocha.getDescription());
    }
}
