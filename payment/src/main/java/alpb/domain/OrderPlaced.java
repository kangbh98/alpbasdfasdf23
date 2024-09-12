package alpb.domain;

import alpb.domain.*;
import alpb.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long orderId;
    private Long userId;
    private Integer product;
}
