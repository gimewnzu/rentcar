package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class NotAvailabled extends AbstractEvent {

    private Long id;

    public NotAvailabled(Point aggregate) {
        super(aggregate);
    }

    public NotAvailabled() {
        super();
    }
}
//>>> DDD / Domain Event
