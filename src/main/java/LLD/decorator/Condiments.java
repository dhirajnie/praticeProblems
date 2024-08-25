package LLD.decorator;

/*
a substance such as salt, mustard, or pickle that is used to add flavour to food.
 */
public abstract class Condiments extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}
