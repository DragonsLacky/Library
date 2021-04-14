package mk.emt.lab.library.config;

import lombok.AllArgsConstructor;
import mk.emt.lab.library.config.filter.AuthenticationFilter;
import mk.emt.lab.library.config.filter.AuthorizationFilter;
import mk.emt.lab.library.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("jwt")
@AllArgsConstructor
public class JWTWebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UserAuthenticationProvider authenticationProvider;
    private final UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                //.anyRequest().authenticated()
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager(),userService, passwordEncoder))
                .addFilter(new AuthorizationFilter(authenticationManager(), userService))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
