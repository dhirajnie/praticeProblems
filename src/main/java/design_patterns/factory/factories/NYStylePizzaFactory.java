package design_patterns.factory.factories;

import design_patterns.factory.abstractFactory.IngridientFactory;
import design_patterns.factory.pizzatype.NyStyleCheesePizza;
import design_patterns.factory.pizzatype.Pizza;

public class NYStylePizzaFactory implements PizzaFactory {
    IngridientFactory ingridientFactory;

    public NYStylePizzaFactory(IngridientFactory ingridientFactory) {
        this.ingridientFactory = ingridientFactory;
    }

    @Override
    public Pizza createPizza(String type) {
        if (type.equals("Cheese")) {
            return new NyStyleCheesePizza(ingridientFactory);
        }
        return null;
    }
}
