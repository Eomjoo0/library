package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MemberResigtered extends AbstractEvent {

    private Long memberId;
    private String name;
    private Integer contactNumber;

    public MemberResigtered(Member aggregate) {
        super(aggregate);
    }

    public MemberResigtered() {
        super();
    }
}
//>>> DDD / Domain Event
