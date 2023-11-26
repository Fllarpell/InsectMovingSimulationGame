package classes.board;

import classes.insects.Insect;
import enumerations.Direction;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Board {
    private final int size;

    private final Map<String, BoardEntity> boardData = new HashMap<String, BoardEntity>();

    public Board(int size) {
        this.size = size;
    }

    public void addEntity(BoardEntity entity) {
        boardData.put(String.valueOf(entity.hashCode()), entity);
    }

    public BoardEntity getEntity(EntityPosition entity) {
        for (BoardEntity boardEntity: boardData.values()) {
            if (entity.equals(boardEntity.entityPosition)) {
                return boardEntity;
            }
        }
        return null;
    }

    public Direction getDirection(Insect insect) {
        return insect.getBestDirection(boardData, size);
    }

    public int getDirectionSum(Insect insect) {
        return insect.travelDirection(getDirection(insect), boardData, size);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Board board = (Board) object;
        return size == board.size && Objects.equals(boardData, board.boardData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, boardData);
    }

}
