package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "borrower")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrower")
    private Long idBorrower;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @OneToOne
    @JoinColumn(name = "borrower_details_id")
    private BorrowerDetails borrowerDetails;
    @OneToMany(mappedBy = "borrower")
    private List<Borrow> borrows;

    public Borrower(){

    }

    public Borrower(String firstName, String lastName, BorrowerDetails borrowerDetails, List<Borrow> borrows) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowerDetails = borrowerDetails;
        this.borrows = borrows;
    }

    public Long getIdBorrower() {
        return idBorrower;
    }

    public void setIdBorrower(Long idBorrower) {
        this.idBorrower = idBorrower;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BorrowerDetails getBorrowerDetails() {
        return borrowerDetails;
    }

    public void setBorrowerDetails(BorrowerDetails borrowerDetails) {
        this.borrowerDetails = borrowerDetails;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }
}
