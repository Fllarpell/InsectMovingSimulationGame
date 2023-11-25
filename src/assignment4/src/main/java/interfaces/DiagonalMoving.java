package interfaces;

import classes.board.BoardEntity;
import enumerations.Direction;
import classes.board.EntityPosition;

import java.util.Map;

public interface DiagonalMoving {
    int getDiagonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize);
    int travelDiagonally(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize);
}
