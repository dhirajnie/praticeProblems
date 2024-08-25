package design_patterns.abstractFactory;

public class MacButton implements Button{
    @Override
    public void press() {
        System.out.println("Mac Button Pressed!");
    }
}
