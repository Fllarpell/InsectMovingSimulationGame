package classes.board;

import classes.insects.Insect;
import enumerations.Direction;

import java.util.HashMap;
import java.util.Map;

/**
 * The class Board contains all entities that are on the board in the HashMap "boardData",
 * also contains the methods that start movements of insect.
 */
public class Board {
    private static int size;

    private final static Map<EntityPosition, BoardEntity> boardData = new HashMap<>();

    /**
     * Instantiates a new Board.
     *
     * @param size the size of board
     */
    public Board(int size) {
        Board.size = size;
    }

    /**
     * Add entity on the board.
     *
     * @param entity the entity
     */
    public void addEntity(BoardEntity entity) {
        boardData.put(entity.entityPosition, entity);
    }

    /**
     * Gets entity from the board.
     *
     * @param entity the entity
     * @return the entity
     */
    public BoardEntity getEntity(EntityPosition entity) {
        for (BoardEntity boardEntity: boardData.values()) {
            if (boardEntity.entityPosition == entity) {
                continue;
            }
            if (entity.equals(boardEntity.entityPosition)) {
                return boardEntity;
            }
        }
        return null;
    }

    /**
     * Gets direction of insect.
     *
     * @param insect the insect
     * @return the direction
     */
    public  Direction getDirection(Insect insect) {
        return insect.getBestDirection(boardData, size);
    }

    /**
     * Gets direction sum of eaten food.
     *
     * @param insect the insect
     * @return the direction sum
     */
    public  int getDirectionSum(Insect insect) {
        return insect.travelDirection(getDirection(insect), boardData, size);
    }

    /**
     * Gets size of the board.
     *
     * @return the size
     */
    public static int getSize() {
        return size;
    }

    /**
     * Gets full data of the board (HashMap).
     *
     * @return the board data
     */
    public Map<EntityPosition, BoardEntity> getBoardData() {
        return boardData;
    }
}