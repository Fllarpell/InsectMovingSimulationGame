package enumerations;

public enum InsectColor {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private final String color;
    InsectColor(String s) {
        this.color = s;
    }

    public String getColor() {
        return color;
    }
}
