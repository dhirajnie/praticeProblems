package LLD.abstractFactory;

public class WindowsButton implements Button{
    @Override
    public void press() {
        System.out.println("Windows Button Pressed!");
    }
}
