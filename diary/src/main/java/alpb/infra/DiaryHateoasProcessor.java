package alpb.infra;

import alpb.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DiaryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Diary>> {

    @Override
    public EntityModel<Diary> process(EntityModel<Diary> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//deletecartoon")
                .withRel("/deletecartoon")
        );

        return model;
    }
}
