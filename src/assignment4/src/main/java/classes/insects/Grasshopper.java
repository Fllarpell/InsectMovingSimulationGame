package classes.insects;

import classes.board.BoardEntity;
import classes.board.EntityPosition;
import classes.board.FoodPoint;
import enumerations.Direction;
import enumerations.InsectColor;

import java.util.HashMap;
import java.util.Map;

/**
 * The class of one of insects "Grasshopper" that able to move only orthogonally jumping one field on the board.
 */
public class Grasshopper extends Insect {

    /**
     * Instantiates a new Grasshopper.
     *
     * @param color          the grasshopper color
     * @param entityPosition the grasshopper position
     */
    public Grasshopper(InsectColor color, EntityPosition entityPosition) {
        super(color, entityPosition);
    }

    @Override
    public Direction getBestDirection(Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        EntityPosition grasshopperPos = this.entityPosition;
        Map<Direction, Integer> mapFoodAte = new HashMap<>();
        mapFoodAte.put(Direction.N, getGrasshopperVisibleValue(Direction.N, grasshopperPos, boardData, boardSize));
        mapFoodAte.put(Direction.E, getGrasshopperVisibleValue(Direction.E, grasshopperPos, boardData, boardSize));
        mapFoodAte.put(Direction.S, getGrasshopperVisibleValue(Direction.S, grasshopperPos, boardData, boardSize));
        mapFoodAte.put(Direction.W, getGrasshopperVisibleValue(Direction.W, grasshopperPos, boardData, boardSize));

        Direction directionChosen = Direction.N;
        int maxAteFood = 0;
        for (Direction direction: Direction.values()) {
            if (mapFoodAte.containsKey(direction) && mapFoodAte.get(direction) > maxAteFood) {
                maxAteFood = mapFoodAte.get(direction);
                directionChosen = direction;
            }
        }
        return directionChosen;
    }

    /**
     * Gets all visible values on the direction.
     *
     * @param dir            the direction
     * @param entityPosition the insect position
     * @param boardData      the board data
     * @param boardSize      the board size
     * @return eaten food on the direction
     */
    public int getGrasshopperVisibleValue(Direction dir, EntityPosition entityPosition,
                                          Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        int eatenfood = 0;
        int entityCoordinateX = entityPosition.getX();
        int entityCoordinateY = entityPosition.getY();

        for (BoardEntity food: boardData.values()) {
            int foodPosX = food.entityPosition.getX();
            int foodPosY = food.entityPosition.getY();
            if (food instanceof FoodPoint) {
                switch (dir.getTextRepresentation()) {
                    case "North":
                        if (foodPosX == entityCoordinateX && foodPosY < entityCoordinateY
                                && (entityCoordinateY - foodPosY) % 2 == 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "East":
                        if (foodPosX > entityCoordinateX && foodPosY == entityCoordinateY
                                && (foodPosX - entityCoordinateX) % 2 == 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "South":
                        if (foodPosX == entityCoordinateX && foodPosY > entityCoordinateY
                                && (foodPosY - entityCoordinateY) % 2 == 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "West":
                        if (foodPosX < entityCoordinateX && foodPosY == entityCoordinateY
                                && (entityCoordinateX - foodPosX) % 2 == 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                }
            }
        }
        return eatenfood;
    }

    @Override
    public int travelDirection(Direction dir, Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        return travelJumpDirection(dir, entityPosition,  boardData, boardSize);
    }

    /**
     * moving on the chosen direction on th board.
     *
     * @param dir            the direction
     * @param entityPosition the insect position
     * @param boardData      the board data
     * @param boardSize      the board size
     * @return amount of eaten food on the chosen direction
     */
    public int travelJumpDirection(Direction dir, EntityPosition entityPosition,
                                   Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        InsectColor grasshopperColor = ((Insect) boardData.get(entityPosition)).getColor();
        int actuallyPositionX = entityPosition.getX();
        int actuallyPositionY = entityPosition.getY();
        EntityPosition position = new EntityPosition(actuallyPositionX, actuallyPositionY);
        int deltaX = 0;
        int deltaY = 0;
        switch (dir.getTextRepresentation()) {
            case "North":
                deltaY = -2;
                break;
            case "East":
                deltaX = 2;
                break;
            case "South":
                deltaY = 2;
                break;
            case "West":
                deltaX = -2;
                break;
        }
        return Insect.calculateCollectedFood(entityPosition, position,
                grasshopperColor, deltaX, deltaY, boardData, boardSize);
    }
}