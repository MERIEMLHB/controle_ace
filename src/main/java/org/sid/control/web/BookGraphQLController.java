package org.sid.control.web;

import lombok.AllArgsConstructor;
import org.sid.control.service.BookService;
import org.sid.control.dto.BookDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
@AllArgsConstructor
public class BookGraphQLController {

    private final BookService bookService;


    @MutationMapping
    public BookDto saveBook(@Argument BookDto book) {
        return bookService.saveBook(book);
    }


    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }

    // Query pour obtenir les livres par titre
    @QueryMapping
    public List<BookDto> getBooksByTitle(@Argument String title) {
        return BookService.getBooksByTitle(title);
    }

    // Query pour obtenir les livres par titre et auteur
    @QueryMapping
    public List<BookDto> getBooksByTitleAndAuthor(@Argument String title, @Argument String author) {
        return bookService.getBooksByTitleAndAuthor(title, author);
    }
}
