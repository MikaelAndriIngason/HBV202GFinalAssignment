package is.hi.mai24.hbv202g.finalproject;

public class UserOrBookDoesNotExistException extends Exception {

    /**
     * UserOrBookDoesNotExistException constructor.
     * @param message exception message
     */
    public UserOrBookDoesNotExistException(String message) {
        super(message);
    }
}
