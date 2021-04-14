package mk.emt.lab.library.model.exception;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String category) {
        super(String.format("Could not find a category with name: %s", category));
    }
}
