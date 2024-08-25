package design_patterns.factory.pizzatype;

import design_patterns.factory.abstractFactory.IngridientFactory;

public abstract class Pizza {

    IngridientFactory ingridientFactory;

  public   abstract void bake();

    public void cut() {
        System.out.println("Cutting piza!");
    }

  public   void box() {
        System.out.println("Boxing the pizza!");
    }
}
