package interfaces;

import classes.board.BoardEntity;
import classes.board.EntityPosition;
import enumerations.Direction;

import java.util.Map;

/**
 * The interface contains the methods for creatures capable of moving diagonally.
 */
public interface DiagonalMoving {
    /**
     * Gets diagonal direction visible value.
     *
     * @param dir            the direction
     * @param entityPosition the insect position
     * @param boardData      the board data
     * @param boardSize      the board size
     * @return the diagonal direction all visible value
     */
    int getDiagonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition,
                                         Map<EntityPosition, BoardEntity> boardData, int boardSize);

    /**
     * Travel diagonally int.
     *
     * @param dir            the direction
     * @param entityPosition the insect position
     * @param boardData      the board data
     * @param boardSize      the board size
     * @return the all food on the direction
     */
    int travelDiagonally(Direction dir, EntityPosition entityPosition,
                         Map<EntityPosition, BoardEntity> boardData, int boardSize);
}