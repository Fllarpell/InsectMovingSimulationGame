package exceptions.insects;

public class DuplicateInsectException extends Exception {
    @Override
    public String getMessage() {
        return "Duplicate insects";
    }
}