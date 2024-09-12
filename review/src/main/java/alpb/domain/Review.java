package alpb.domain;

import alpb.ReviewApplication;
import alpb.domain.ReviewCreated;
import alpb.domain.ReviewDeleted;
import alpb.domain.ReviewUpdated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewIdx;

    private Integer userIdx;

    private String placeName;

    private String comment;

    private Integer trafficScore;

    private Integer travelScore;

    private Integer foodScore;

    private Integer totalScore;

    @Embedded
    private review_status reviewStatus;

    @PostPersist
    public void onPostPersist() {
        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        ReviewUpdated reviewUpdated = new ReviewUpdated(this);
        reviewUpdated.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        reviewDeleted.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    //<<< Clean Arch / Port Method
    public void deleteReview() {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
