package alpb.infra;

import alpb.config.kafka.KafkaProcessor;
import alpb.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DiaryViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DiaryRepository diaryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDiaryCreated_then_CREATE_1(
        @Payload DiaryCreated diaryCreated
    ) {
        try {
            if (!diaryCreated.validate()) return;

            // view 객체 생성
            Diary diary = new Diary();
            // view 객체에 이벤트의 Value 를 set 함
            diary.setId(diaryCreated.getDiaryId());
            diary.setDate(diaryCreated.getDate());
            diary.setUserIdx(diaryCreated.getUserIdx());
            diary.setImageUrl(diaryCreated.getImageUrl());
            diary.setComment(diaryCreated.getComment());
            diary.setDiaryStatus(ACTIVE);
            // view 레파지 토리에 save
            diaryRepository.save(diary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDiaryDeleted_then_DELETE_1(
        @Payload DiaryDeleted diaryDeleted
    ) {
        try {
            if (!diaryDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            diaryRepository.deleteById(diaryDeleted.getDiaryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
