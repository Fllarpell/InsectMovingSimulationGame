package classes.insects;

import classes.board.BoardEntity;
import classes.board.EntityPosition;
import classes.board.FoodPoint;
import enumerations.Direction;
import enumerations.InsectColor;
import interfaces.DiagonalMoving;

import java.util.HashMap;
import java.util.Map;

/**
 * The class of one of insects "Spider" that able to move only diagonally on the board.
 */
public class Spider extends Insect implements DiagonalMoving {

    /**
     * Instantiates a new Spider.
     *
     * @param color          the spider color
     * @param entityPosition the spider position
     */
    public Spider(InsectColor color, EntityPosition entityPosition) {
        super(color, entityPosition);
    }

    @Override
    public Direction getBestDirection(Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        EntityPosition spiderPos = this.entityPosition;
        Map<Direction, Integer> mapFoodAte = new HashMap<>();
        mapFoodAte.put(Direction.NE, getDiagonalDirectionVisibleValue(Direction.NE, spiderPos, boardData, boardSize));
        mapFoodAte.put(Direction.SE, getDiagonalDirectionVisibleValue(Direction.SE, spiderPos, boardData, boardSize));
        mapFoodAte.put(Direction.SW, getDiagonalDirectionVisibleValue(Direction.SW, spiderPos, boardData, boardSize));
        mapFoodAte.put(Direction.NW, getDiagonalDirectionVisibleValue(Direction.NW, spiderPos, boardData, boardSize));

        Direction directionChosen = Direction.NE;
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
        return travelDiagonally(dir, entityPosition, boardData, boardSize);
    }

    @Override
    public int getDiagonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition,
                                                Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        int eatenfood = 0;
        int entityCoordinateX = entityPosition.getX();
        int entityCoordinateY = entityPosition.getY();

        for (BoardEntity food: boardData.values()) {
            int foodPosX = food.entityPosition.getX();
            int foodPosY = food.entityPosition.getY();
            if (food instanceof FoodPoint) {
                switch (dir.getTextRepresentation()) {
                    case "North-East":
                        if (foodPosX - entityCoordinateX == entityCoordinateY - foodPosY
                                && foodPosX - entityCoordinateX > 0
                                && entityCoordinateY - foodPosY > 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "South-East":
                        if (foodPosX - entityCoordinateX == foodPosY - entityCoordinateY
                                && foodPosX - entityCoordinateX > 0
                                && foodPosY - entityCoordinateY > 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "South-West":
                        if (entityCoordinateX - foodPosX == foodPosY - entityCoordinateY
                                && entityCoordinateX - foodPosX > 0
                                && foodPosY - entityCoordinateY > 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                    case "North-West":
                        if (entityCoordinateX - foodPosX == entityCoordinateY - foodPosY
                                && entityCoordinateX - foodPosX > 0
                                && entityCoordinateY - foodPosY > 0) {
                            eatenfood += ((FoodPoint) food).getValue();
                        }
                        break;
                }
            }
        }
        return eatenfood;
    }

    @Override
    public int travelDiagonally(Direction dir, EntityPosition entityPosition,
                                Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        int entityCoordinateX = entityPosition.getX();
        int entityCoordinateY = entityPosition.getY();
        EntityPosition position = new EntityPosition(entityCoordinateX, entityCoordinateY);
        InsectColor spiderColor = this.getColor();
        int deltaX = 0;
        int deltaY = 0;
        switch (dir.getTextRepresentation()) {
            case "North-East":
                deltaY = -1;
                deltaX = 1;
                break;
            case "South-East":
                deltaX = 1;
                deltaY = 1;
                break;
            case "South-West":
                deltaY = 1;
                deltaX = -1;
                break;
            case "North-West":
                deltaX = -1;
                deltaY = -1;
                break;
        }
        return Insect.calculateCollectedFood(entityPosition, position,
                spiderColor, deltaX, deltaY, boardData, boardSize);
    }
}