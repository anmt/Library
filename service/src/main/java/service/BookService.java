package service;

import dtos.BookDto;
import model.Book;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {

    BookRepository bookRepository = new BookRepository();

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book b: books){
            BookDto bookDto = new BookDto();
            bookDto.setAuthorName(b.getAuthor().getFirstName()+" "+b.getAuthor().getLastName());
            bookDto.setBookId(b.getIdBook());
            bookDto.setBorrowerName(null);
            bookDto.setCategory(b.getCategory());
            bookDto.setIsbn(b.getIsbn());
            bookDto.setTitle(b.getTitle());
            bookDto.setReleaseDate(b.getReleaseDate());
            bookDtos.add(bookDto);
        }
        return bookDtos;

    }
}
