package mk.emt.lab.library.model.exception;

public class BookDoesNotHaveAvailableCopiesException extends Exception{
    public BookDoesNotHaveAvailableCopiesException(Long id) {
        super(String.format("No copies available for book with id: %s", id));
    }
}
