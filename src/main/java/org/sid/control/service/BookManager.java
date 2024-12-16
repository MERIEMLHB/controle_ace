package org.sid.control.service;

import org.sid.control.dao.entities.Book;
import org.sid.control.dao.repositories.BookRepository;
import org.sid.control.dto.BookDto;
import org.sid.control.mapper.BookMapper;

import java.util.ArrayList;
import java.util.List;


    public class BookManager implements BookService {
        private BookRepository bookRepository;
        private BookMapper bookMapper;

        public BookManager(BookRepository bookRepository, BookMapper bookMapper) {
            this.bookRepository = bookRepository;
            this.bookMapper = bookMapper;
        }


        public BookDto saveBook(BookDto bookDto) {
            Book book = bookMapper.fromBookDtoToBook(bookDto);
            book = bookRepository.save(book);
            return bookMapper.fromBookToBookDto(book);
        }


        public boolean deleteBook(Long id) {
            try {
                bookRepository.deleteById(id);
                return true;
            } catch (Exception exception) {
                return false;
            }
        }


        public List<BookDto> getBooksByTitle(String title) {
            List<Book> books = bookRepository.findByTitle(title);
            List<BookDto> bookDtos = new ArrayList<>();
            for (Book book : books) {
                bookDtos.add(bookMapper.fromBookToBookDto(book));
            }
            return bookDtos;
        }


        public List<BookDto> getBooksByTitleAndAuthor(String title, String author) {
            List<Book> books = bookRepository.findByTitleAndAuthor(title, author);
            List<BookDto> bookDtos = new ArrayList<>();
            for (Book book : books) {
                bookDtos.add(bookMapper.fromBookToBookDto(book));
            }
            return bookDtos;
        }


        public List<BookDto> saveBooks(List<BookDto> bookDtos) {
            List<Book> books = new ArrayList<>();
            for (BookDto bookDto : bookDtos) {
                books.add(bookMapper.fromBookDtoToBook(bookDto));
            }

            books = bookRepository.saveAll(books);

            bookDtos = new ArrayList<>();
            for (Book book : books) {
                bookDtos.add(bookMapper.fromBookToBookDto(book));
            }
            return bookDtos;
        }
    }

