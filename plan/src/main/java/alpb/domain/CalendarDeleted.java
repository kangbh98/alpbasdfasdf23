package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CalendarDeleted extends AbstractEvent {

    private Long planIdx;
    private Integer userIdx;
    private String placeName;
    private String address;
    private String phone;
    private String category;
    private String date;
    private String time;

    public CalendarDeleted(Plan aggregate) {
        super(aggregate);
    }

    public CalendarDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
