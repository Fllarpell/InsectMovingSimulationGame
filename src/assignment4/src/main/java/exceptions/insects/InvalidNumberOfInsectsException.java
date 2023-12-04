package exceptions.insects;

/**
 * The class of exception that in case of error related with amount of insects on the board throw the exception.
 */
public class InvalidNumberOfInsectsException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid number of insects";
    }
}
