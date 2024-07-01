package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.infra.AbstractEvent;
import lombok.Data;

@Data
public class BookReturned extends AbstractEvent {

    private Integer bookId;
    private String title;
    private String author;
    private String publisher;
    private Date publish_date;
}
