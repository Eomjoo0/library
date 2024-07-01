package library.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import library.BookApplication;
import library.domain.BookCheckedout;
import library.domain.BookReturned;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    private Integer bookId;

    private String title;

    private String author;

    private String publisher;

    private Date publishDate;

    @PostPersist
    public void onPostPersist() {
        BookCheckedout bookCheckedout = new BookCheckedout(this);
        bookCheckedout.publishAfterCommit();

        BookReturned bookReturned = new BookReturned(this);
        bookReturned.publishAfterCommit();
    }

    public static BookRepository repository() {
        BookRepository bookRepository = BookApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }
}
//>>> DDD / Aggregate Root
