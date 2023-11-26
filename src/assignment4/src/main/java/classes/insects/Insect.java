package classes.insects;

import classes.board.BoardEntity;
import enumerations.Direction;
import classes.board.EntityPosition;
import enumerations.InsectColor;

import java.util.Map;
public abstract class Insect extends BoardEntity {
    protected InsectColor color;

    public Insect(InsectColor color, EntityPosition entityPosition) {
        this.color = color;
        this.entityPosition = entityPosition;
    }

    public abstract Direction getBestDirection(Map<String, BoardEntity> boardData, int boardSize);
    public abstract int travelDirection(Direction dir, Map<String, BoardEntity> boardData, int boardSize);

    public InsectColor getColor() {
        return color;
    }
}
