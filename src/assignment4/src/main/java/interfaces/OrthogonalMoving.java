package interfaces;

import classes.board.BoardEntity;
import classes.board.EntityPosition;
import enumerations.Direction;

import java.util.Map;

/**
 * The interface contains the methods for creatures capable of moving orthogonally.
 */
public interface OrthogonalMoving {
    /**
     * Gets orthogonal direction visible value.
     *
     * @param dir            the direction
     * @param entityPosition the insect position
     * @param boardData      the board data
     * @param boardSize      the board size
     * @return the orthogonal direction all visible value
     */
    int getOrthogonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition,
                                           Map<EntityPosition, BoardEntity> boardData, int boardSize);

    /**
     * Travel orthogonally int.
     *
     * @param dir            the direction
     * @param entityPosition the insect position
     * @param boardData      the board data
     * @param boardSize      the board size
     * @return the all food on the direction
     */
    int travelOrthogonally(Direction dir, EntityPosition entityPosition,
                           Map<EntityPosition, BoardEntity> boardData, int boardSize);
}