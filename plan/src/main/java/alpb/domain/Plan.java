package alpb.domain;

import alpb.PlanApplication;
import alpb.domain.CalendarDeleted;
import alpb.domain.PlanAdded;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Plan_table")
@Data
//<<< DDD / Aggregate Root
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long planIdx;

    private Integer userIdx;

    private String placeName;

    private String address;

    private String phone;

    private String category;

    private Date date;

    private String time;

    @Embedded
    private plan_status planStatus;

    @PostPersist
    public void onPostPersist() {
        PlanAdded planAdded = new PlanAdded(this);
        planAdded.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    @PreRemove
    public void onPreRemove() {
        CalendarDeleted calendarDeleted = new CalendarDeleted(this);
        calendarDeleted.publishAfterCommit();
    }

    public static PlanRepository repository() {
        PlanRepository planRepository = PlanApplication.applicationContext.getBean(
            PlanRepository.class
        );
        return planRepository;
    }

    //<<< Clean Arch / Port Method
    public void deletePlan() {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
