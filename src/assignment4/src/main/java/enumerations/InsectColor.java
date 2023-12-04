package enumerations;

/**
 * The enumeration InsectColor contains all colors that creatures can take on.
 */
public enum InsectColor {
    /**
     * Red insect color.
     */
    RED,
    /**
     * Green insect color.
     */
    GREEN,
    /**
     * Blue insect color.
     */
    BLUE,
    /**
     * Yellow insect color.
     */
    YELLOW;

    /**
     * To enumeration color from text color of insect.
     *
     * @param s the string color
     * @return the insect color
     */
    public static InsectColor toColor(String s) {
        switch (s) {
            case "Red":
                return InsectColor.RED;
            case "Green":
                return InsectColor.GREEN;
            case "Blue":
                return InsectColor.BLUE;
            case "Yellow":
                return InsectColor.YELLOW;
        }
        return null;
    }
}