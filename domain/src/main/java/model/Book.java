package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;
    private Boolean borrow;
    private String category;
    @Column(nullable = false)
    private String isbn;
    private Integer pages;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private String summary;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;


}
