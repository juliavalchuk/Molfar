package ua.julia.spring.molfar.repository;

import ua.julia.spring.molfar.domain.Question;

import java.util.List;

/**
 * Created by julia
 */
public interface QuestionRepository {
    Long getNumberOfQuestions();
    List<Question> getNClassname(int n);
    Question getQuestionByClassName(String classname);
    List<Question> getAllQuestions();
    void save(Question question);
}
