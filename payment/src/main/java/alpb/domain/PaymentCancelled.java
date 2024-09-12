package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;

    public PaymentCancelled(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
