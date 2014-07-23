package ua.julia.spring.molfar.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.julia.spring.molfar.domain.Book;
import ua.julia.spring.molfar.domain.Question;
import ua.julia.spring.molfar.service.Algorithm;
import ua.julia.spring.molfar.service.QuestionService;

import java.util.List;
import java.util.Locale;

/**
 * Created by julia
 */

@RestController
@Api(value = "news", description = "News API")
public class WebControler {
    Algorithm algorithm;
    QuestionService questionService;
    String lang = "en";

    @Autowired
    public WebControler(Algorithm algorithm, QuestionService questionService) {
        this.algorithm = algorithm;
        this.questionService = questionService;
    }

    @RequestMapping({"/", "/home"})
    public void home(@RequestParam(value="lang", required=false, defaultValue="en") String lang){
        this.lang = lang;

    }

    @RequestMapping(value = {"/question"}, method = RequestMethod.GET)
    public @ResponseBody String questions(Locale locale){
        System.out.println(locale.getLanguage());
        Question question = algorithm.getQuestion();
        String langQuestion = questionService.getSQuestionByLocal(question, lang);
        return langQuestion;
    }

    @RequestMapping(value = {"/question"}, method = RequestMethod.POST)
    public @ResponseBody String getQuestion(@RequestParam(value="answer") Integer answer){
        Question question = algorithm.getQuestion(answer);
        if(question != null) {
            String langQuestion = questionService.getSQuestionByLocal(question, lang);
            return langQuestion;
        }
        return null;
    }

    @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
    public @ResponseBody List<Book> result(){
        List<Book> books = algorithm.getResult();
        return books;
    }

}
