package repository;

import model.Author;

public interface IAuthorRepository {

    void add(Author author);

    void modify(Author author);

    void remove(Long id);

    Author findById(Long id);

    void cleanUp();

}
