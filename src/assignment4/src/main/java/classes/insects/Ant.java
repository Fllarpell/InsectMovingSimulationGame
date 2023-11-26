package classes.insects;
import classes.board.BoardEntity;
import enumerations.Direction;
import classes.board.EntityPosition;
import enumerations.InsectColor;
import interfaces.DiagonalMoving;
import interfaces.OrthogonalMoving;

import java.util.Map;

public class Ant extends Insect implements OrthogonalMoving, DiagonalMoving {
    public Ant(InsectColor color, EntityPosition entityPosition) {
        super(color, entityPosition);
    }

    @Override
    public Direction getBestDirection(Map<String, BoardEntity> boardData, int boardSize) {
        return null;
    }

    @Override
    public int travelDirection(Direction dir, Map<String, BoardEntity> boardData, int boardSize) {
        return 0;
    }

    @Override
    public int getDiagonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize) {
        return 0;
    }

    @Override
    public int travelDiagonally(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize) {
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
