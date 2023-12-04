package classes.board;

/**
 * The class of food that contains amount value of food and coordinates of food.
 */
public class FoodPoint extends BoardEntity {
    /**
     * The Value of food.
     */
    protected int value;

    /**
     * Instantiates a new Food point.
     *
     * @param value  the value of food
     * @param entity the entity position on the board
     */
    public FoodPoint(int value, EntityPosition entity) {
        this.value = value;
        this.entityPosition = entity;
    }

    /**
     * Gets value of food.
     *
     * @return the value of food
     */
    public int getValue() {
        return value;
    }
}