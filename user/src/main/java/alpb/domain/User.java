package alpb.domain;

import alpb.UserApplication;
import alpb.domain.CreditDecreased;
import alpb.domain.CreditIncreased;
import alpb.domain.UserLoggedIn;
import alpb.domain.UserLoggedOut;
import alpb.domain.UserSignedUp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userIdx;

    private String email;

    private String password;

    private String nickname;

    private String profileImg;

    private String refreshToken;

    private Integer credit;

    @PostPersist
    public void onPostPersist() {
        UserSignedUp userSignedUp = new UserSignedUp(this);
        userSignedUp.publishAfterCommit();

        UserLoggedIn userLoggedIn = new UserLoggedIn(this);
        userLoggedIn.publishAfterCommit();

        UserLoggedOut userLoggedOut = new UserLoggedOut(this);
        userLoggedOut.publishAfterCommit();

        CreditIncreased creditIncreased = new CreditIncreased(this);
        creditIncreased.publishAfterCommit();

        CreditDecreased creditDecreased = new CreditDecreased(this);
        creditDecreased.publishAfterCommit();
    }

    public static UserRepository repository() {
        UserRepository userRepository = UserApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseCredit(PaymentApproved paymentApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        User user = new User();
        repository().save(user);

        CreditIncreased creditIncreased = new CreditIncreased(user);
        creditIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(user->{
            
            user // do something
            repository().save(user);

            CreditIncreased creditIncreased = new CreditIncreased(user);
            creditIncreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void decreaseCredit(DiaryCreated diaryCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        User user = new User();
        repository().save(user);

        CreditDecreased creditDecreased = new CreditDecreased(user);
        creditDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(diaryCreated.get???()).ifPresent(user->{
            
            user // do something
            repository().save(user);

            CreditDecreased creditDecreased = new CreditDecreased(user);
            creditDecreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
