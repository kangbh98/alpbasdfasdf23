package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DiaryDeleted extends AbstractEvent {

    private Long diaryId;
    private Date date;
    private Integer userIdx;
    private String imageUrl;
    private String comment;

    public DiaryDeleted(Diary aggregate) {
        super(aggregate);
    }

    public DiaryDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
