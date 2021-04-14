package mk.emt.lab.library.model.exception;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(Long id) {
        super(String.format("Could not find a product with id: %s", id));
    }
}
