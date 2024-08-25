package design_patterns.abstractFactory;

public class MacApplication implements UIApplication {
    Button button;
    Checkbox checkbox;

    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public Checkbox getCheckBox() {
        return null;
    }
}
