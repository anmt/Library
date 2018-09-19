package repository;

import model.BorrowerDetails;

public interface IBorrowerDetailsRepository {

    void add(BorrowerDetails borrowerDetails);

    void modify(BorrowerDetails borrowerDetails);

    void remove(Long id);

    BorrowerDetails findById(Long id);



}
