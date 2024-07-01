package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookCheckedout extends AbstractEvent {

    private Integer bookId;
    private String title;
    private String author;
    private String publisher;
    private Date publishDate;

    public BookCheckedout(Book aggregate) {
        super(aggregate);
    }

    public BookCheckedout() {
        super();
    }
}
//>>> DDD / Domain Event
