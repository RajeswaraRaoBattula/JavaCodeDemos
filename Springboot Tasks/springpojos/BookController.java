package springcontroller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springpojos.Book;
import springpojos.BookListWrapper;

@RestController
public class BookController {

    @GetMapping(value = "/bookXYZ", produces = "application/xml")
    public BookListWrapper getBooks() {
        return new BookListWrapper(
            Arrays.asList(
                new Book(101, "Java Tutorials", "Krishna"),
                new Book(102, "Spring Tutorials", "Mahesh"),
                new Book(103, "Angular Tutorials", "Shiva")
            )
        );
    }
}
