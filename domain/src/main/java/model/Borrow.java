package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrow")
    private Long idBorrow;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;
    @Column(name = "rental_date", nullable = false)
    private LocalDate rentalDate;


    public Long getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(Long idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }
}
