package mk.emt.lab.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.emt.lab.library.model.enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@NoArgsConstructor
@Table(name = "app_user")
public class User implements UserDetails {
    @Id
    private String username;
    
    private String password;
    
    @Version
    private Long version;
    
    private String name;
    private String lastname;
    
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;
    
    @Enumerated(value = EnumType.STRING)
    private Role role;
    
    public User(String username, String password, String name, String lastname, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }
    
    @Override
    public String getPassword() {
        return null;
    }
    
    @Override
    public String getUsername() {
        return null;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }
    
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
