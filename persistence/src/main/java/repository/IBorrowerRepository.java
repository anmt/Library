package repository;

import model.Borrower;

public interface IBorrowerRepository {

    void add(Borrower borrower);

    void modify(Borrower borrower);

    void remove(Long id);

    Borrower findById(Long id);

    void cleanUp();

}
