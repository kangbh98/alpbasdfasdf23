package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewUpdated extends AbstractEvent {

    private Long reviewIdx;
    private Integer userIdx;
    private String placeName;
    private String comment;
    private Integer trafficScore;
    private Integer travelScore;
    private Integer foodScore;
    private Integer totalScore;

    public ReviewUpdated(Review aggregate) {
        super(aggregate);
    }

    public ReviewUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
