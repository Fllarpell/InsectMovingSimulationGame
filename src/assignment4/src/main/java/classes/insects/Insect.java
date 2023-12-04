package classes.insects;

import classes.Main;
import classes.board.BoardEntity;
import classes.board.EntityPosition;
import classes.board.FoodPoint;
import enumerations.Direction;
import enumerations.InsectColor;

import java.util.Map;

/**
 * The class of insects that contains color of insect, coordinates of insect on the board
 * and common method for all insects.
 */
public abstract class Insect extends BoardEntity {
    /**
     * The Color of insect.
     */
    protected InsectColor color;

    /**
     * Instantiates a new Insect.
     *
     * @param color          the color of insect
     * @param entityPosition the insect position on the board
     */
    public Insect(InsectColor color, EntityPosition entityPosition) {
        this.color = color;
        this.entityPosition = entityPosition;
    }

    /**
     * Gets best direction of insect.
     *
     * @param boardData the board data
     * @param boardSize the board size
     * @return the best direction of insect
     */
    public abstract Direction getBestDirection(Map<EntityPosition, BoardEntity> boardData, int boardSize);

    /**
     * Start moving insect on the board.
     *
     * @param dir       the direction
     * @param boardData the board data
     * @param boardSize the board size
     * @return amount of eaten food
     */
    public abstract int travelDirection(Direction dir, Map<EntityPosition, BoardEntity> boardData, int boardSize);

    /**
     * Calculate collected food on the chosen direction.
     *
     * @param entityPosition the insect position
     * @param position       the copy of insect position
     * @param color          the color of insect
     * @param deltaX         the delta x
     * @param deltaY         the delta y
     * @param boardData      the board data
     * @param boardSize      the board size
     * @return amount of eaten food on the chosen direction
     */
    public static int calculateCollectedFood(EntityPosition entityPosition, EntityPosition position,
                                             InsectColor color, int deltaX, int deltaY,
                                             Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        int eatenfood = 0;
        while (true) {
            int pointFood = 0;
            position.setY(position.getY() + deltaY);
            position.setX(position.getX() + deltaX);
            if (position.getY() > boardSize
                    || position.getY() < 1
                    || position.getX() > boardSize
                    || position.getX() < 1) {
                boardData.remove(entityPosition);
                break;
            }
            if (Main.getGameBoard().getEntity(position) != null) {
                BoardEntity entity = Main.getGameBoard().getEntity(position);
                if (entity instanceof Insect) {
                    if (!(((Insect) entity).getColor() == color)) {
                        pointFood = -1;
                    }
                } else if (entity instanceof FoodPoint) {
                    pointFood = ((FoodPoint) entity).getValue();
                    boardData.remove(entity.entityPosition);

                }
            }
            if (pointFood == -1) {
                boardData.remove(entityPosition);
                return eatenfood;
            }
            eatenfood += pointFood;
        }
        return eatenfood;
    }

    /**
     * Gets color of insect.
     *
     * @return the color of insect
     */
    public InsectColor getColor() {
        return color;
    }
}