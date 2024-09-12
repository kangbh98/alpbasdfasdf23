package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.util.*;
import lombok.*;

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
}
