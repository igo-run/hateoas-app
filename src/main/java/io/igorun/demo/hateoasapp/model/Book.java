package io.igorun.demo.hateoasapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends RepresentationModel<Book> {
    private String id;
    private String name;
    private Author author;
    private Publisher publisher;
}
