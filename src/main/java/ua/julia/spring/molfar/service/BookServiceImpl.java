package ua.julia.spring.molfar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.julia.spring.molfar.domain.Book;
import ua.julia.spring.molfar.repository.BookRepository;

import java.util.List;

/**
 * Created by julia
 */
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Long getNumberOfBook() {
        return bookRepository.getNumberOfBook();
    }

    @Override
    public List<Book> getAllBoks() {
        return bookRepository.getAllBoks();
    }

    @Override
    public List<Book> findToClazz(String classname) {
        return bookRepository.findToClazz(classname);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
