package repository;

import model.Book;

import java.util.List;

public interface IBookRepository {

    void add(Book book);

    void modify(Book book);

    void remove(Long id);

    Book findById(Long id);

    List<Book> findAll();

}
