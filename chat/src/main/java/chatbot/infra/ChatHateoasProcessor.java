package chatbot.infra;

import chatbot.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ChatHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Chat>> {

    @Override
    public EntityModel<Chat> process(EntityModel<Chat> model) {
        return model;
    }
}
