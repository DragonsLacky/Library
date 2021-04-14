package mk.emt.lab.library.model.dto;

import lombok.Data;
import mk.emt.lab.library.model.Author;
import mk.emt.lab.library.model.enumeration.Category;

import javax.persistence.ManyToOne;

@Data
public class BookDto {
    
    private String name;
    
    private String category;
    
    private Long author;
    
    private Integer availableCopies;
    
}
