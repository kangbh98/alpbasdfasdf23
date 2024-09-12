package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewDeleted extends AbstractEvent {

    private Long reviewIdx;
    private Integer userIdx;
    private String placeName;
    private String comment;
    private Integer trafficScore;
    private Integer travelScore;
    private Integer foodScore;
    private Integer totalScore;

    public ReviewDeleted(Review aggregate) {
        super(aggregate);
    }

    public ReviewDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
