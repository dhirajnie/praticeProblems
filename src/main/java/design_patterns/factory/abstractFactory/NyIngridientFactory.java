package design_patterns.factory.abstractFactory;

public class NyIngridientFactory  implements IngridientFactory{
    @Override
    public Cheese createCheese() {
        return new NyCheese();
    }

    @Override
    public Souce createSouce() {
        return new NyStyleSouce();
    }
}
