package alpb.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Diary_table")
@Data
public class Diary {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long diaryId;
    private Date date;
    private Integer userIdx;
    private String imageUrl;
    private String comment;
    private String diaryStatus;
}
