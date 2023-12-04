package classes.board;

import java.util.Objects;

/**
 * The class that set coordinates of entity on the board.
 */
public class EntityPosition {
    private int x;
    private int y;

    /**
     * Instantiates a new Entity position.
     *
     * @param x the x position on the board
     * @param y the y position on the board
     */
    public EntityPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x position on the board.
     *
     * @return the x position on the board
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y position on the board.
     *
     * @return the y position on the board
     */
    public int getY() {
        return y;
    }

    /**
     * Sets x position on the board.
     *
     * @param x the x position on the board
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y position on the board.
     *
     * @param y the y position on the board
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        EntityPosition that = (EntityPosition) object;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}