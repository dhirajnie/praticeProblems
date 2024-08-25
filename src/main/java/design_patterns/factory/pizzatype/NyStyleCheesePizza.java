package design_patterns.factory.pizzatype;

import design_patterns.factory.abstractFactory.Cheese;
import design_patterns.factory.abstractFactory.IngridientFactory;

public class NyStyleCheesePizza extends Pizza{
    public NyStyleCheesePizza(IngridientFactory ingridientFactory) {
    this.ingridientFactory = ingridientFactory;
    }


    @Override
   public void bake() {
        Cheese cheese = ingridientFactory.createCheese();
        System.out.println(cheese.getCheese());
        System.out.println("Baking the pizza in NY Style");
    }
}
