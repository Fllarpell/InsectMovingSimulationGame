package exceptions.insects;

/**
 * The class of exception that in case of error related with distinct of insects throw the exception.
 */
public class DuplicateInsectException extends Exception {
    @Override
    public String getMessage() {
        return "Duplicate insects";
    }
}
