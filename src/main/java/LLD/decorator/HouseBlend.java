package LLD.decorator;

public class HouseBlend extends Beverage {

    HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
