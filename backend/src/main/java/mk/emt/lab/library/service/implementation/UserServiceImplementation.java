package mk.emt.lab.library.service.implementation;

import mk.emt.lab.library.model.enumeration.Role;
import mk.emt.lab.library.model.exception.InvalidUsernameOrPasswordException;
import mk.emt.lab.library.model.exception.PasswordsDoNotMatchException;
import mk.emt.lab.library.model.exception.UserNotFoundException;
import mk.emt.lab.library.repository.UserRepository;
import mk.emt.lab.library.service.UserService;
import mk.emt.lab.library.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public User register(String username, String password, String repeatPassword, String name, String lastname, Role role) throws InvalidUsernameOrPasswordException, PasswordsDoNotMatchException {
        if(username == null || username.isBlank() || password == null || password.isBlank()) throw new InvalidUsernameOrPasswordException();
        if(!password.equals(repeatPassword)) throw new PasswordsDoNotMatchException();
        User user = new User(username, passwordEncoder.encode(password), name, lastname, role);
        return userRepository.save(user);
    }
    
    @Override
    public UserDetails loadUserByUsername(String s) {
        return userRepository.findById(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }
}
