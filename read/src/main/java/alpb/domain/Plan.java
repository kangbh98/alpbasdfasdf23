package alpb.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Plan_table")
@Data
public class Plan {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long planIdx;
    private Integer userIdx;
    private String placeName;
    private String address;
    private String phone;
    private String date;
    private String time;
    private String planStatus;
}
