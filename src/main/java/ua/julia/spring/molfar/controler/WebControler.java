package ua.julia.spring.molfar.controler;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@Api(value = "molfar", description = "Molfar API")
public class WebControler {
    Algorithm algorithm;
    QuestionService questionService;
    String lang = "en";

    @Autowired
    public WebControler(Algorithm algorithm, QuestionService questionService) {
        this.algorithm = algorithm;
        this.questionService = questionService;
    }

    @RequestMapping(value = {"/", "/home"})
    @ApiOperation(value = "Put language", notes = "Set language of application")
    @ResponseStatus(HttpStatus.OK)
    public void home(@ApiParam(name="lang", value="The language of datas") @RequestParam(value="lang", required=false, defaultValue="en") String lang){
        this.lang = lang;

    }

    @ApiOperation(
            value = "Get first question",
            notes = "Get first rnd question",
            response = String.class
    )
    @RequestMapping(value = {"/question"}, method = RequestMethod.GET)
    public @ResponseBody String questions(Locale locale){
        System.out.println(locale.getLanguage());
        algorithm.setInitialValue();
        Question question = algorithm.getQuestion();
        String langQuestion = questionService.getSQuestionByLocal(question, lang);
        return langQuestion;
    }

    @ApiOperation(
            value = "Post answer on previous question and get next question",
            notes = "Get next question",
            response = String.class
    )
    @RequestMapping(value = {"/question"}, method = RequestMethod.POST)
    public @ResponseBody String getQuestion(@ApiParam(name="answer", value="The answer oh a previous question", required = true) @RequestParam(value="answer") Integer answer){
        Question question = algorithm.getQuestion(answer);
        if(question != null) {
            String langQuestion = questionService.getSQuestionByLocal(question, lang);
            return langQuestion;
        }
        return null;
    }


    @ApiOperation(
            value = "Get results",
            notes = "Returs JSON array of 5 elements",
            response = Book.class,
            responseContainer = "List"
    )
    @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
    public @ResponseBody List<Book> result(){
        List<Book> books = algorithm.getResult();
        return books;
    }

}
