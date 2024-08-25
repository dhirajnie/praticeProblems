package design_patterns.factory.factories;

import design_patterns.factory.abstractFactory.IngridientFactory;
import design_patterns.factory.pizzatype.Pizza;

public interface PizzaFactory {

    Pizza createPizza(String type);
}
