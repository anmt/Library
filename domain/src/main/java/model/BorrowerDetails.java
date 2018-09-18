package model;

import javax.persistence.*;

@Entity
@Table(name = "borrower_details")
public class BorrowerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrower_details")
    private Long idBorrowerDetails;
    private String address;
    private String email;
    private String phone;
    @OneToOne(mappedBy = "borrowerDetails")
    private Borrower borrower;

    public BorrowerDetails(){

    }

    public BorrowerDetails(String address, String email, String phone, Borrower borrower) {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.borrower = borrower;
    }

    public Long getIdBorrowerDetails() {
        return idBorrowerDetails;
    }

    public void setIdBorrowerDetails(Long idBorrowerDetails) {
        this.idBorrowerDetails = idBorrowerDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}
