package library.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import library.LoanApplication;
import library.domain.LoanCreated;
import library.domain.LoanExpired;
import lombok.Data;

@Entity
@Table(name = "Loan_table")
@Data
//<<< DDD / Aggregate Root
public class Loan {

    @Id
    private Integer loanId;

    private Integer bookId;

    private Integer memberId;

    private Date loanDate;

    private Date dueDate;

    private Date returnDate;

    @PostUpdate
    public void onPostUpdate() {
        LoanCreated loanCreated = new LoanCreated(this);
        loanCreated.publishAfterCommit();

        LoanExpired loanExpired = new LoanExpired(this);
        loanExpired.publishAfterCommit();
    }

    public static LoanRepository repository() {
        LoanRepository loanRepository = LoanApplication.applicationContext.getBean(
            LoanRepository.class
        );
        return loanRepository;
    }

    //<<< Clean Arch / Port Method
    public static void bookStockCheck(BookCheckedout bookCheckedout) {
        //implement business logic here:

        /** Example 1:  new item 
        Loan loan = new Loan();
        repository().save(loan);

        LoanCreated loanCreated = new LoanCreated(loan);
        loanCreated.publishAfterCommit();
        LoanExpired loanExpired = new LoanExpired(loan);
        loanExpired.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(bookCheckedout.get???()).ifPresent(loan->{
            
            loan // do something
            repository().save(loan);

            LoanCreated loanCreated = new LoanCreated(loan);
            loanCreated.publishAfterCommit();
            LoanExpired loanExpired = new LoanExpired(loan);
            loanExpired.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void bookStockCheck(BookReturned bookReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        Loan loan = new Loan();
        repository().save(loan);

        LoanCreated loanCreated = new LoanCreated(loan);
        loanCreated.publishAfterCommit();
        LoanExpired loanExpired = new LoanExpired(loan);
        loanExpired.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(bookReturned.get???()).ifPresent(loan->{
            
            loan // do something
            repository().save(loan);

            LoanCreated loanCreated = new LoanCreated(loan);
            loanCreated.publishAfterCommit();
            LoanExpired loanExpired = new LoanExpired(loan);
            loanExpired.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
