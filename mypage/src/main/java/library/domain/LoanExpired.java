package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.infra.AbstractEvent;
import lombok.Data;

@Data
public class LoanExpired extends AbstractEvent {

    private Integer loanId;
    private Integer bookId;
    private Integer memberId;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;
}
