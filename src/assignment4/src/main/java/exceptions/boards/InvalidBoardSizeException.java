package exceptions.boards;

/**
 * The class of exception that in case of error related with invalid size of the board throw the exception.
 */
public class InvalidBoardSizeException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid board size";
    }
}
