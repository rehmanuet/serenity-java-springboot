package DriverManager;

public enum Driver {
    APPIUM("Appium"),
    FIREFOX("Firefox"),
    CHROME("Chrome"),
    EDGE("Edge"),
    SAFARI("Safari"),
    ANDROID("Android"),
    IOS("Ios");

    private String name;

    Driver(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
