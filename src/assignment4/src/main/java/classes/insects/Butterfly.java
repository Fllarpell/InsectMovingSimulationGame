package classes.insects;

import classes.board.BoardEntity;
import classes.board.EntityPosition;
import classes.board.FoodPoint;
import enumerations.InsectColor;
import enumerations.Direction;
import interfaces.OrthogonalMoving;

import java.util.HashMap;
import java.util.Map;

/**
 * The class of one of insects "Butterfly" that able to move only orthogonally on the board.
 */
public class Butterfly extends Insect implements OrthogonalMoving {

    /**
     * Instantiates a new Butterfly.
     *
     * @param color          the butterfly color
     * @param entityPosition the butterfly position
     */
    public Butterfly(InsectColor color, EntityPosition entityPosition) {
        super(color, entityPosition);
    }

    @Override
    public Direction getBestDirection(Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        EntityPosition butterflyPos = this.entityPosition;
        Map<Direction, Integer> mapFoodAte = new HashMap<>();
        mapFoodAte.put(Direction.N,
                getOrthogonalDirectionVisibleValue(Direction.N, butterflyPos, boardData, boardSize));
        mapFoodAte.put(Direction.E,
                getOrthogonalDirectionVisibleValue(Direction.E, butterflyPos, boardData, boardSize));
        mapFoodAte.put(Direction.S,
                getOrthogonalDirectionVisibleValue(Direction.S, butterflyPos, boardData, boardSize));
        mapFoodAte.put(Direction.W,
                getOrthogonalDirectionVisibleValue(Direction.W, butterflyPos, boardData, boardSize));

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

    @Override
    public int travelDirection(Direction dir, Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        return travelOrthogonally(dir, entityPosition, boardData, boardSize);
    }

    @Override
    public int getOrthogonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition,
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
                        if (foodPosX == entityCoordinateX && foodPosY < entityCoordinateY) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "East":
                        if (foodPosX > entityCoordinateX && foodPosY == entityCoordinateY) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "South":
                        if (foodPosX == entityCoordinateX && foodPosY > entityCoordinateY) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "West":
                        if (foodPosX < entityCoordinateX && foodPosY == entityCoordinateY) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                }
            }
        }
        return eatenfood;
    }
    @Override
    public int travelOrthogonally(Direction dir, EntityPosition entityPosition,
                                  Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        InsectColor butterflyColor = ((Insect) boardData.get(entityPosition)).getColor();
        int actuallyPositionX = entityPosition.getX();
        int actuallyPositionY = entityPosition.getY();
        EntityPosition position = new EntityPosition(actuallyPositionX, actuallyPositionY);
        int deltaX = 0;
        int deltaY = 0;
        switch (dir.getTextRepresentation()) {
            case "North":
                deltaY = -1;
                break;
            case "East":
                deltaX = 1;
                break;
            case "South":
                deltaY = 1;
                break;
            case "West":
                deltaX = -1;
                break;
        }
        return Insect.calculateCollectedFood(entityPosition, position,
                butterflyColor, deltaX, deltaY, boardData, boardSize);
    }
}