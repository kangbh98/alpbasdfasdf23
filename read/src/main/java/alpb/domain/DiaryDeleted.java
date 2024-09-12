package alpb.domain;

import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DiaryDeleted extends AbstractEvent {

    private Long diary_id;
    private Date date;
    private Integer user_idx;
    private String image_url;
    private String comment;
}
