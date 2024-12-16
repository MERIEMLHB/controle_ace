package org.sid.control.service;

import org.sid.control.dao.repositories.BookRepository;
import org.sid.control.dto.BookDto;
import org.sid.control.mapper.BookMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto saveBook(BookDto bookDto) {
        return bookMapper.fromBookToBookDto(
                bookRepository.save(bookMapper.fromBookDtoToBook(bookDto))
        );
    }

    @Override
    public List<BookDto> getBooksByTitle(String title) {
        return bookRepository.findByTitre(title)
                .stream()
                .map(bookMapper::fromBookToBookDto)
                .collect(Collectors.toList());
    }
}
