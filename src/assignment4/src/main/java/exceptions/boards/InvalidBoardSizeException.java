package exceptions.boards;

public class InvalidBoardSizeException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid board size";
    }
}