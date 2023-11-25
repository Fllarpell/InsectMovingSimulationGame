package classes.insects;

import classes.board.BoardEntity;
import enumerations.Direction;
import classes.board.EntityPosition;
import enumerations.InsectColor;

import java.util.Map;

public class Grasshopper extends Insect {
    public Grasshopper(InsectColor color, EntityPosition entityPosition) {
        super(color, entityPosition);
    }

    @Override
    public Direction getBestDirection(Map<String, BoardEntity> boardData, int boardSize) {
        return null;
    }

    @Override
    public int travelDirection(int direction, Map<String, BoardEntity> boardData, int boardSize) {
        return 0;
    }
}
