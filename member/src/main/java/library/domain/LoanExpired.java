package library.domain;

import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class LoanExpired extends AbstractEvent {

    private Integer loanId;
    private Integer bookId;
    private Integer memberId;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;
}
