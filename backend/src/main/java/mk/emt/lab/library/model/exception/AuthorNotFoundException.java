package mk.emt.lab.library.model.exception;

public class AuthorNotFoundException extends Exception {
    
    public AuthorNotFoundException(Long id) {
        super(String.format("Could not find Author with id: %d", id));
    }
}
