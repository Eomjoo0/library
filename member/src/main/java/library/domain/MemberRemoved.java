package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MemberRemoved extends AbstractEvent {

    private Long memberId;
    private String name;
    private Integer contactNumber;

    public MemberRemoved(Member aggregate) {
        super(aggregate);
    }

    public MemberRemoved() {
        super();
    }
}
//>>> DDD / Domain Event
