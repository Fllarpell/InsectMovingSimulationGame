package exceptions.insects;

/**
 * The class of exception that in case of error related with invalid type of insect throw the exception.
 */
public class InvalidInsectTypeException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid insect type";
    }
}
