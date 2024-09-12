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
    DiaryRepository diaryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CalendarDeleted'"
    )
    public void wheneverCalendarDeleted_DeleteDiary(
        @Payload CalendarDeleted calendarDeleted
    ) {
        CalendarDeleted event = calendarDeleted;
        System.out.println(
            "\n\n##### listener DeleteDiary : " + calendarDeleted + "\n\n"
        );

        // Sample Logic //
        Diary.deleteDiary(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
