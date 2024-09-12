package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;
}
