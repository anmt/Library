package repository;

import model.Borrow;

public interface IBorrowRepository {

    void add(Borrow borrow);

    void remove(Long id);

    Borrow findById(Long id);

    void cleanUp();

}
