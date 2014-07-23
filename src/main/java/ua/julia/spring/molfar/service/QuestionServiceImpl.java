package ua.julia.spring.molfar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.julia.spring.molfar.domain.Localization;
import ua.julia.spring.molfar.domain.Question;
import ua.julia.spring.molfar.repository.QuestionRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by julia
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Long getNumberOfQuestions() {
        return questionRepository.getNumberOfQuestions();
    }

    @Override
    public String getRNDClassname() {
        int n = 10;
        List<Question> list = questionRepository.getNClassname(n);
        return list.get((int) (Math.random() * n)).getClassname();
    }

    @Override
    public Question getQuestionByClassName(String classname) {
        return questionRepository.getQuestionByClassName(classname);
    }

    @Override
    public String getSQuestionByClassNameAdnLocal(String classname, String lang) {
        return getSQuestionByLocal(questionRepository.getQuestionByClassName(classname), lang);
    }

    @Override
    public String getSQuestionByLocal(Question question, String lang) {
        Set<Localization> localizations = question.getLocalization();


        if(localizations == null){
            return question.getClassname() + "?";
        }

        String strquestion = null;
        for (Localization localization : localizations) {
            if(localization.getKey().equals(lang)){
                strquestion = localization.getValue();
                break;
            }
        }

        if(strquestion == null) {
            return question.getClassname() + "?";
        }

        return strquestion;
    }


    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.getAllQuestions();
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }
}
