package exceptions.boards;

/**
 * The class of exception that in case of error related with the same coordinates of any insects throw the exception.
 */
public class TwoEntitiesOnSamePositionException extends Exception {
    @Override
    public String getMessage() {
        return "Two entities in the same position";
    }
}
