package interfaces;

import classes.board.BoardEntity;
import enumerations.Direction;
import classes.board.EntityPosition;

import java.util.Map;

public interface OrthogonalMoving {
    int getOrthogonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize);
    int travelOrthogonally(Direction dir, EntityPosition entityPosition, Map<String, BoardEntity> boardData, int boardSize);
}
