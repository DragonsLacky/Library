package mk.emt.lab.library.model.exception;

import org.springframework.security.core.AuthenticationException;

public class PasswordsDoNotMatchException extends AuthenticationException {
    public PasswordsDoNotMatchException() {
        super("Passwords do not match");
    }
}
