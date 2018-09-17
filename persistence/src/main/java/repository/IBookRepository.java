package repository;

import model.Book;

public interface IBookRepository {

    void add(Book book);

    void modify(Book book);

    void remove(Long id);

    Book findById(Long id);

    void cleanUp();

}
