package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookReturned extends AbstractEvent {

    private Integer bookId;
    private String title;
    private String author;
    private String publisher;
    private Date publishDate;

    public BookReturned(Book aggregate) {
        super(aggregate);
    }

    public BookReturned() {
        super();
    }
}
//>>> DDD / Domain Event
