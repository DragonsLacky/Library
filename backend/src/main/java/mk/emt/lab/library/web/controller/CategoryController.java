package mk.emt.lab.library.web.controller;

import mk.emt.lab.library.model.enumeration.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {
    
    @GetMapping
    public List<String> listCategories(){
        return Arrays.stream(Category.values()).map(category -> category.toString().toLowerCase()).collect(Collectors.toList());
    }
}
