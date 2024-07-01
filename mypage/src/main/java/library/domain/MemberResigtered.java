package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.infra.AbstractEvent;
import lombok.Data;

@Data
public class MemberResigtered extends AbstractEvent {

    private Long memberId;
    private String name;
    private Integer contact_number;
}
