package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PlanAdded extends AbstractEvent {

    private Long planIdx;
    private Integer userIdx;
    private String placeName;
    private String address;
    private String phone;
    private String category;
    private String date;
    private String time;

    public PlanAdded(Plan aggregate) {
        super(aggregate);
    }

    public PlanAdded() {
        super();
    }
}
//>>> DDD / Domain Event
