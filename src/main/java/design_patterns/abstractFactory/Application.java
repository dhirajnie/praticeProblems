package design_patterns.abstractFactory;

public class Application {
UIApplication uiApplication;

    public Application(UIApplication uiApplication) {
        this.uiApplication = uiApplication;
    }


    public static void main(String[] args) {
        Application app = new Application(new MacApplication());
        app.uiApplication.getButton().press();
    }
}
