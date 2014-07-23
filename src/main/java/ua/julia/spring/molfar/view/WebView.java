package ua.julia.spring.molfar.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.julia.spring.molfar.domain.Book;

import java.util.List;

/**
 * Created by julia
 */

@Controller
public class WebView implements Viewable {
    @Override
    @RequestMapping(value="/create", method= RequestMethod.GET)
    public int showQuestion(int number, String question) {

        return 0;
    }

    @Override
    public void showResult(List<Book> books) {

    }
}
