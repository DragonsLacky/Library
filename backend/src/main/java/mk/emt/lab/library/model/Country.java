package mk.emt.lab.library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Country {
    
    @Id
    Long id ;
    
    String name ;
    
    String continent ;
    
}
