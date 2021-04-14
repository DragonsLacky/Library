package mk.emt.lab.library.config;

import mk.emt.lab.library.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    
    private final UserService userService;
    
    public UserAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }
    
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
