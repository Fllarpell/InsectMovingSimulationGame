package enumerations;

/**
 * The enumeration Direction contains all directions for moving.
 */
public enum Direction {
    /**
     * N direction.
     */
    N("North"),
    /**
     * E direction.
     */
    E("East"),
    /**
     * S direction.
     */
    S("South"),
    /**
     * W direction.
     */
    W("West"),
    /**
     * NE direction.
     */
    NE("North-East"),
    /**
     * SE direction.
     */
    SE("South-East"),
    /**
     * SW direction.
     */
    SW("South-West"),
    /**
     * NW direction.
     */
    NW("North-West");

    private final String textRepresentation;


    Direction(String text) {
        this.textRepresentation = text;
    }

    /**
     * Gets text representation of direction.
     *
     * @return the text representation
     */
    public String getTextRepresentation() {
        return textRepresentation;
    }
}