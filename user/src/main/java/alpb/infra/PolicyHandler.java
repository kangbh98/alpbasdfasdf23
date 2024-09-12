package alpb.infra;

import alpb.config.kafka.KafkaProcessor;
import alpb.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    UserRepository userRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentApproved'"
    )
    public void wheneverPaymentApproved_IncreaseCredit(
        @Payload PaymentApproved paymentApproved
    ) {
        PaymentApproved event = paymentApproved;
        System.out.println(
            "\n\n##### listener IncreaseCredit : " + paymentApproved + "\n\n"
        );

        // Sample Logic //
        User.increaseCredit(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DiaryCreated'"
    )
    public void wheneverDiaryCreated_DecreaseCredit(
        @Payload DiaryCreated diaryCreated
    ) {
        DiaryCreated event = diaryCreated;
        System.out.println(
            "\n\n##### listener DecreaseCredit : " + diaryCreated + "\n\n"
        );

        // Sample Logic //
        User.decreaseCredit(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
