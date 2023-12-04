package exceptions.insects;

/**
 * The class of exception that in case of error related with invalid color of insect throw the exception.
 */
public class InvalidInsectColorException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid insect color";
    }
}
