package exceptions.boards;

/**
 * The class of exception that in case of error related with invalid coordinates of food or insect throw the exception.
 */
public class InvalidEntityPositionException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid entity position";
    }
}
