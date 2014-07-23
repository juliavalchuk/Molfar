package ua.julia.spring.molfar.service;

import ua.julia.spring.molfar.domain.Book;

import java.util.List;

/**
 * Created by julia
 */
public interface BookService {
    Long getNumberOfBook();
    List<Book> getAllBoks();
    List<Book> findToClazz(String classname);
    void save(Book book);
}
