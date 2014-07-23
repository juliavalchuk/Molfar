package ua.julia.spring.molfar.view;

import ua.julia.spring.molfar.domain.Book;

import java.util.List;

/**
 * Created by julia
 */
public interface Viewable {

    public int showQuestion(int number, String question); //  1 - yes, 2 - no, 3 - another...
    public void showResult(List<Book> books);
}
