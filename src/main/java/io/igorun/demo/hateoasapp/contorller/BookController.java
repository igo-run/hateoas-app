package io.igorun.demo.hateoasapp.contorller;

import io.igorun.demo.hateoasapp.model.Author;
import io.igorun.demo.hateoasapp.model.Book;
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
@RequestMapping(path = "/books")
public class BookController {
    @GetMapping(path = "/{bookId}")
    public ResponseEntity<EntityModel<Book>> doGetBookById(@PathVariable("bookId") String bookId) {
        Link self = linkTo(methodOn(BookController.class).doGetBookById(bookId)).withSelfRel();

        return ResponseEntity.ok(EntityModel.of(Book.builder()
                                                    .id(bookId)
                                                    .name(fooString())
                                                    .author(dummyAuthor())
                                                    .publisher(dummyPublisher())
                                                    .build(), self));
    }

    private Publisher dummyPublisher() {
        Publisher publisher = Publisher.builder()
                                       .id(fooString())
                                       .name(fooString())
                                       .build();
        publisher.add(linkTo(methodOn(PublisherController.class).doGetPublisherById(fooString())).withSelfRel());
        return publisher;
    }

    private Author dummyAuthor() {
        Author author = Author.builder().id(fooString()).name(fooString()).build();
        author.add(linkTo(methodOn(AuthorController.class).doGetAuthorById(fooString())).withSelfRel());
        return author;
    }

}
