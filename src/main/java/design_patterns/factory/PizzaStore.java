package design_patterns.factory;

import design_patterns.factory.factories.PizzaFactory;
import design_patterns.factory.pizzatype.Pizza;

public class PizzaStore {

    PizzaFactory pizzaFactory;

    public PizzaStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    void orderPizza(String type){
        Pizza pizza = pizzaFactory.createPizza(type);
        pizza.bake();
        pizza.cut();
        pizza.box();
    }


}
