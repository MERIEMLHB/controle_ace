package org.sid.control.mapper;

import org.modelmapper.ModelMapper;
import org.sid.control.dao.entities.Book;
import org.sid.control.dto.BookDto;

public class BookMapper {
    private final ModelMapper mapper = new ModelMapper();

  
    public Book fromBookDtoToBook(BookDto bookDto) {
        return mapper.map(bookDto, Book.class);
    }

  
    public BookDto fromBookToBookDto(Book book) {
        return mapper.map(book, BookDto.class);
    }
}
