package LLD.decorator;

public class Espresso extends Beverage{
    public Espresso(){
        this.description="Espresso";
    }
    @Override
    public double cost() {
        return 2;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
