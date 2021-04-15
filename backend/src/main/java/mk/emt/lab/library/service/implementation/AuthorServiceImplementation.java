package mk.emt.lab.library.service.implementation;

import mk.emt.lab.library.model.Author;
import mk.emt.lab.library.repository.AuthorRepository;
import mk.emt.lab.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {
    
    private final AuthorRepository authorRepository;
    
    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
