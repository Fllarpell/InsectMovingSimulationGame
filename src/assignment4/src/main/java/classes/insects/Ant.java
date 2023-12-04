package classes.insects;

import classes.board.BoardEntity;
import classes.board.EntityPosition;
import enumerations.InsectColor;
import enumerations.Direction;
import interfaces.DiagonalMoving;
import interfaces.OrthogonalMoving;

import java.util.HashMap;
import java.util.Map;

/**
 * The class of one of insects "Ant" that able to move orthogonally and diagonally on the board.
 */
public class Ant extends Insect implements OrthogonalMoving, DiagonalMoving {
    /**
     * Instantiates a new Ant.
     *
     * @param color          the color of ant
     * @param entityPosition the ant position
     */
    public Ant(InsectColor color, EntityPosition entityPosition) {
        super(color, entityPosition);
    }

    @Override
    public Direction getBestDirection(Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        EntityPosition antPos = this.entityPosition;
        Map<Direction, Integer> mapFoodAte = new HashMap<>();
        mapFoodAte.put(Direction.N, getOrthogonalDirectionVisibleValue(Direction.N, antPos, boardData, boardSize));
        mapFoodAte.put(Direction.E, getOrthogonalDirectionVisibleValue(Direction.E, antPos, boardData, boardSize));
        mapFoodAte.put(Direction.S, getOrthogonalDirectionVisibleValue(Direction.S, antPos, boardData, boardSize));
        mapFoodAte.put(Direction.W, getOrthogonalDirectionVisibleValue(Direction.W, antPos, boardData, boardSize));
        mapFoodAte.put(Direction.NE, getDiagonalDirectionVisibleValue(Direction.NE, antPos, boardData, boardSize));
        mapFoodAte.put(Direction.SE, getDiagonalDirectionVisibleValue(Direction.SE, antPos, boardData, boardSize));
        mapFoodAte.put(Direction.SW, getDiagonalDirectionVisibleValue(Direction.SW, antPos, boardData, boardSize));
        mapFoodAte.put(Direction.NW, getDiagonalDirectionVisibleValue(Direction.NW, antPos, boardData, boardSize));

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
        if (dir.ordinal() < Direction.NE.ordinal()) {
            return travelOrthogonally(dir, entityPosition, boardData, boardSize);
        } else {
            return travelDiagonally(dir, entityPosition, boardData, boardSize);
        }
    }

    @Override
    public int getDiagonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition,
                                                Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        Spider spider = new Spider(this.color, entityPosition);
        return spider.getDiagonalDirectionVisibleValue(dir, entityPosition, boardData, boardSize);
    }

    @Override
    public int getOrthogonalDirectionVisibleValue(Direction dir, EntityPosition entityPosition,
                                                  Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        Butterfly butterfly = new Butterfly(this.color, entityPosition);
        return butterfly.getOrthogonalDirectionVisibleValue(dir, entityPosition, boardData, boardSize);
    }

    @Override
    public int travelOrthogonally(Direction dir, EntityPosition entityPosition,
                                  Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        Butterfly butterfly = new Butterfly(this.color, entityPosition);
        return butterfly.travelOrthogonally(dir, entityPosition, boardData, boardSize);
    }

    @Override
    public int travelDiagonally(Direction dir, EntityPosition entityPosition,
                                Map<EntityPosition, BoardEntity> boardData, int boardSize) {
        Spider spider = new Spider(this.color, entityPosition);
        return spider.travelDiagonally(dir, entityPosition, boardData, boardSize);
    }
}