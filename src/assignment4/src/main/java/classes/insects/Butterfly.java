package classes.insects;

import classes.board.BoardEntity;
import enumerations.Direction;
import classes.board.EntityPosition;
import enumerations.InsectColor;
import interfaces.OrthogonalMoving;

import java.util.Map;

public class Butterfly extends Insect implements OrthogonalMoving {

    public Butterfly(InsectColor color, EntityPosition entityPosition) {
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

    @Override
    public int getOrthogonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize) {
        return 0;
    }

    @Override
    public int travelOrthogonally(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize) {
        return 0;
    }
}