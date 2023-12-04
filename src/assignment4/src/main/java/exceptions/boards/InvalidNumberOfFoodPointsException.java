package exceptions.boards;

/**
 * The class of exception that in case of error related with amount of food on the board throw the exception.
 */
public class InvalidNumberOfFoodPointsException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid number of food points";
    }
}
