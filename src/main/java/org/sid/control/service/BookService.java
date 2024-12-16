package org.sid.control.service;

import org.sid.control.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto saveBook(BookDto bookDto);

     default List<BookDto> getBooksByTitle(String title) {
        return null;
    }

    Boolean deleteBook(Long id);

    List<BookDto> getBooksByTitleAndAuthor(String title, String author);
}
