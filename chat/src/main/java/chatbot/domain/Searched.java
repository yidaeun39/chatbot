package chatbot.domain;

import chatbot.domain.*;
import chatbot.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Searched extends AbstractEvent {

    private Long id;
    private String productId;
    private String questionMsg;
    private String requestMsg;
    private String requestType;
    private String userId;

    public Searched(Chat aggregate) {
        super(aggregate);
    }

    public Searched() {
        super();
    }
}
//>>> DDD / Domain Event
