package mk.emt.lab.library.model.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundException extends AuthenticationException {
    public UserNotFoundException() {
        super("Invalid credentials");
    }
}
