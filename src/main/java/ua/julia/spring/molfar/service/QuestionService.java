package ua.julia.spring.molfar.service;

import ua.julia.spring.molfar.domain.Question;

import java.util.List;

/**
 * Created by julia
 */

public interface QuestionService {
    Long getNumberOfQuestions();
    String getRNDClassname();
    Question getQuestionByClassName(String classname);
    String getSQuestionByClassNameAdnLocal(String classname, String lang);
    String getSQuestionByLocal(Question question, String lang);
    List<Question> getAllQuestions();
    void save(Question question);
}
