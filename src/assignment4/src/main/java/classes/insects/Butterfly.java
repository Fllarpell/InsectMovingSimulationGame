package classes.insects;

import classes.board.BoardEntity;
import classes.board.FoodPoint;
import enumerations.Direction;
import classes.board.EntityPosition;
import enumerations.InsectColor;
import interfaces.OrthogonalMoving;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Butterfly extends Insect implements OrthogonalMoving {

    public Butterfly(InsectColor color, EntityPosition entityPosition) {
        super(color, entityPosition);
    }

    @Override
    public Direction getBestDirection(Map<String, BoardEntity> boardData, int boardSize) {
        int butterflyPosition = this.hashCode();
        int butterflyPositionX = boardData.get(butterflyPosition).getEntityPosition().getX();
        int butterflyPositionY = boardData.get(butterflyPosition).getEntityPosition().getY();
        Integer[] foodPoint = new Integer[Direction.W.ordinal()];
        for (BoardEntity boardEntity : boardData.values()) {
            if (boardEntity instanceof FoodPoint) {
                int foodPositionX = boardEntity.getEntityPosition().getX();
                int foodPositionY = boardEntity.getEntityPosition().getY();
                if (foodPositionX <= butterflyPositionX && foodPositionY == butterflyPositionY) {
                    foodPoint[Direction.N.ordinal()] += ((FoodPoint) boardEntity).getValue();
                } else if (foodPositionX >= butterflyPositionX && foodPositionY == butterflyPositionY) {
                    foodPoint[Direction.E.ordinal()] += ((FoodPoint) boardEntity).getValue();
                } else if (foodPositionX == butterflyPositionX && foodPositionY <= butterflyPositionY) {
                    foodPoint[Direction.S.ordinal()] += ((FoodPoint) boardEntity).getValue();
                } else if (foodPositionX == butterflyPositionX && foodPositionY >= butterflyPositionY) {
                    foodPoint[Direction.W.ordinal()] += ((FoodPoint) boardEntity).getValue();
                }
            }
        }
        int max = Collections.max(Arrays.asList(foodPoint));
        for (Direction direction : Direction.values()) {
            if (direction.ordinal() == max) {
                return direction;
            }
        }
        return Direction.N;
    }

    @Override
    public int travelDirection(Direction dir, Map<String, BoardEntity> boardData, int boardSize) {
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