package io.igorun.demo.hateoasapp.contorller;

import io.igorun.demo.hateoasapp.model.Publisher;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.igorun.demo.hateoasapp.util.Utils.fooString;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/publishers")
public class PublisherController {
    @GetMapping(path = "/{publisherId}")
    public ResponseEntity<EntityModel<Publisher>> doGetPublisherById(@PathVariable("publisherId") String publisherId) {
        Link link = linkTo(methodOn(PublisherController.class)
                .doGetPublisherById(publisherId)).withSelfRel();

        return ResponseEntity.ok(EntityModel.of(Publisher.builder()
                                                         .id(publisherId)
                                                         .name(fooString())
                                                         .build(), link));
    }
}
