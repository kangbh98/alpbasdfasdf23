package alpb.domain;

import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CalendarDeleted extends AbstractEvent {

    private Long plan_idx;
    private Integer user_idx;
    private String place_name;
    private String address;
    private String phone;
    private String category;
    private String date;
    private String time;
}
