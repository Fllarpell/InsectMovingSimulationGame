package classes.board;

import classes.board.BoardEntity;
import classes.board.EntityPosition;

public class FoodPoint extends BoardEntity {
    protected int value;

    public FoodPoint(int value, EntityPosition entity) {
        this.value = value;
        this.entityPosition = entity;
    }

    public int getValue() {
        return value;
    }
}
