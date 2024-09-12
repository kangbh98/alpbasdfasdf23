package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UserLoggedOut extends AbstractEvent {

    private Long userIdx;
    private String email;
    private String password;
    private String nickname;
    private String profileImg;
    private String refreshToken;
    private Integer credit;

    public UserLoggedOut(User aggregate) {
        super(aggregate);
    }

    public UserLoggedOut() {
        super();
    }
}
//>>> DDD / Domain Event
