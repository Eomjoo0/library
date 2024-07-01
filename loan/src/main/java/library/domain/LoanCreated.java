package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LoanCreated extends AbstractEvent {

    private Integer loanId;
    private Integer bookId;
    private Integer memberId;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;

    public LoanCreated(Loan aggregate) {
        super(aggregate);
    }

    public LoanCreated() {
        super();
    }
}
//>>> DDD / Domain Event
