package design_patterns.abstractFactory;

public class MacApplicationFactory implements UIApplication{

    @Override
    public Button getButton() {
        return null;
    }

    @Override
    public Checkbox getCheckBox() {
        return null;
    }
}