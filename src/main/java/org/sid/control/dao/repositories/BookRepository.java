package org.sid.control.dao.repositories;

import org.sid.control.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findByTitre(String titre);

    List<Book> findByTitleAndAuthor(String title, String author);

    List<Book> findByTitle(String title);
}
