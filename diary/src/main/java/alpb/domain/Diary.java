package alpb.domain;

import alpb.DiaryApplication;
import alpb.domain.DiaryCreated;
import alpb.domain.DiaryDeleted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Diary_table")
@Data
//<<< DDD / Aggregate Root
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long diaryId;

    private Date date;

    private Integer userIdx;

    private String imageUrl;

    private String comment;

    @Embedded
    private cartoon_status diaryStatus;

    @PostPersist
    public void onPostPersist() {
        DiaryCreated diaryCreated = new DiaryCreated(this);
        diaryCreated.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        DiaryDeleted diaryDeleted = new DiaryDeleted(this);
        diaryDeleted.publishAfterCommit();
    }

    public static DiaryRepository repository() {
        DiaryRepository diaryRepository = DiaryApplication.applicationContext.getBean(
            DiaryRepository.class
        );
        return diaryRepository;
    }

    //<<< Clean Arch / Port Method
    public void deleteDiary() {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void deleteDiary(CalendarDeleted calendarDeleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Diary diary = new Diary();
        repository().save(diary);

        DiaryDeleted diaryDeleted = new DiaryDeleted(diary);
        diaryDeleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(calendarDeleted.get???()).ifPresent(diary->{
            
            diary // do something
            repository().save(diary);

            DiaryDeleted diaryDeleted = new DiaryDeleted(diary);
            diaryDeleted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
