package design_patterns.factory;

import design_patterns.factory.abstractFactory.IngridientFactory;
import design_patterns.factory.abstractFactory.NyIngridientFactory;
import design_patterns.factory.factories.NYStylePizzaFactory;
import design_patterns.factory.factories.PizzaFactory;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

public class Demo {


    public static void main(String[] args) {
        IngridientFactory ingridientFactory = new NyIngridientFactory();
        PizzaStore pizzaStore = new PizzaStore( new NYStylePizzaFactory(ingridientFactory));
        pizzaStore.orderPizza("Cheese");
    }
}
