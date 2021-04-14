package mk.emt.lab.library.model.dto;

import lombok.Data;
import mk.emt.lab.library.model.User;
import mk.emt.lab.library.model.enumeration.Role;

@Data
public class UserDetailsDto {
    
    private String username;
    private Role role;
    
    public static UserDetailsDto of(User user){
        UserDetailsDto details = new UserDetailsDto();
        details.setUsername(user.getUsername());
        details.setRole(user.getRole());
        return details;
    }
}
