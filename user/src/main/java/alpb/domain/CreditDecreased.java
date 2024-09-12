package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CreditDecreased extends AbstractEvent {

    private Long userIdx;
    private String email;
    private String password;
    private String nickname;
    private String profileImg;
    private String refreshToken;
    private Integer credit;

    public CreditDecreased(User aggregate) {
        super(aggregate);
    }

    public CreditDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
