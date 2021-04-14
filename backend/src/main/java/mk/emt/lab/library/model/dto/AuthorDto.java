package mk.emt.lab.library.model.dto;

import lombok.Data;
import mk.emt.lab.library.model.Author;
import mk.emt.lab.library.model.Country;
import mk.emt.lab.library.model.enumeration.Category;

import javax.persistence.ManyToOne;

@Data
public class AuthorDto {
    
    private String name;
    
    private String surname;
    
    private Long country;
    
}
