package mk.emt.lab.library.service;

import mk.emt.lab.library.model.User;
import mk.emt.lab.library.model.enumeration.Role;
import mk.emt.lab.library.model.exception.InvalidUsernameOrPasswordException;
import mk.emt.lab.library.model.exception.PasswordsDoNotMatchException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String lastname, Role role) throws InvalidUsernameOrPasswordException, PasswordsDoNotMatchException;
}
