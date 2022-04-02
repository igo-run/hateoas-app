package io.igorun.demo.hateoasapp.contorller;

import io.igorun.demo.hateoasapp.model.Author;
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
@RequestMapping(path = "authors")
public class AuthorController {
    @GetMapping(path = "/{authorId}")
    public ResponseEntity<EntityModel<Author>> doGetAuthorById(@PathVariable("authorId") String authorId) {
        Link link = linkTo(methodOn(AuthorController.class)
                .doGetAuthorById(authorId)).withSelfRel();

        return ResponseEntity.ok(EntityModel.of(Author.builder()
                                                      .id(authorId)
                                                      .name(fooString())
                                                      .build(), link));
    }
}
