package mk.emt.lab.library.model.event;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public class AddedBookEvent extends ApplicationEvent {
    
    private LocalDateTime updatedOn;
    
    public AddedBookEvent(Object source) {
        super(source);
        this.updatedOn = LocalDateTime.now();
    }
    
    public AddedBookEvent(Object source, LocalDateTime updatedOn) {
        super(source);
        this.updatedOn = updatedOn;
    }
    
}
