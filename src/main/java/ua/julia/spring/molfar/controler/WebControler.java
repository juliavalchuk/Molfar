package ua.julia.spring.molfar.controler;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.julia.spring.molfar.domain.Book;
import ua.julia.spring.molfar.domain.Question;
import ua.julia.spring.molfar.service.Algorithm;
import ua.julia.spring.molfar.service.QuestionService;

import java.util.List;
import java.util.Locale;

/**
 * Created by julia
 */

@Controller
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

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.PUT)
    @ApiOperation(value = "Put language", notes = "Set language of application")
    public void home(@ApiParam(name="lang", value="The language of datas") @RequestParam(value="lang", required=false, defaultValue="en") String lang){
        this.lang = lang;

    }

    @RequestMapping(value = {"/question"}, method = RequestMethod.GET)
    @ApiOperation(value = "Get first question", notes = "Get first rnd question")
    public @ResponseBody String questions(Locale locale){
        System.out.println(locale.getLanguage());
        Question question = algorithm.getQuestion();
        String langQuestion = questionService.getSQuestionByLocal(question, lang);
        return langQuestion;
    }

    @RequestMapping(value = {"/question"}, method = RequestMethod.POST)
    @ApiOperation(value = "Post answer on previous question and get next question", notes = "Get next question")
    public @ResponseBody String getQuestion(@ApiParam(name="answer", value="The answer oh a previous question") @RequestParam(value="answer") Integer answer){
        Question question = algorithm.getQuestion(answer);
        if(question != null) {
            String langQuestion = questionService.getSQuestionByLocal(question, lang);
            return langQuestion;
        }
        return null;
    }
    @ApiOperation(value = "Get results", notes = "Returs JSON array of 5 elements")
    @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
    public @ResponseBody List<Book> result(){
        List<Book> books = algorithm.getResult();
        return books;
    }

}
