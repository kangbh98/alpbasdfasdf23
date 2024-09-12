package alpb.infra;

import alpb.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReviewHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Review>> {

    @Override
    public EntityModel<Review> process(EntityModel<Review> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//deletereview")
                .withRel("/deletereview")
        );

        return model;
    }
}
