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
public class PlanViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private PlanRepository planRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPlanAdded_then_CREATE_1(@Payload PlanAdded planAdded) {
        try {
            if (!planAdded.validate()) return;

            // view 객체 생성
            Plan plan = new Plan();
            // view 객체에 이벤트의 Value 를 set 함
            plan.setId(planAdded.getPlanIdx());
            plan.setUserIdx(planAdded.getUserIdx());
            plan.setPlaceName(planAdded.getPlaceName());
            plan.setAddress(planAdded.getAddress());
            plan.setPhone(planAdded.getPhone());
            plan.setDate(planAdded.getDate());
            plan.setTime(planAdded.getTime());
            plan.setPlanStatus(ACTIVE);
            // view 레파지 토리에 save
            planRepository.save(plan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCalendarDeleted_then_DELETE_1(
        @Payload CalendarDeleted calendarDeleted
    ) {
        try {
            if (!calendarDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            planRepository.deleteById(calendarDeleted.getPlanIdx());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
