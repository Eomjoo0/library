package library.domain;

import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class BookReturned extends AbstractEvent {

    private Integer bookId;
    private String title;
    private String author;
    private String publisher;
    private Date publishDate;
}
