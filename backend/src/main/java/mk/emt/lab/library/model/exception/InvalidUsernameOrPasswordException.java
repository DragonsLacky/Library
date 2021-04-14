package mk.emt.lab.library.model.exception;

public class InvalidUsernameOrPasswordException extends Exception{
    public InvalidUsernameOrPasswordException() {
        super("Invalid username or password");
    }
}
