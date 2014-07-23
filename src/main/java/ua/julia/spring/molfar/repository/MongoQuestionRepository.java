package ua.julia.spring.molfar.repository;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.julia.spring.molfar.domain.Question;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia
 */
@Repository
public class MongoQuestionRepository implements QuestionRepository {
    Jongo jongo;
    MongoCollection questioncoll;

    @Autowired
    public MongoQuestionRepository(MongoTemplate mongoTemplate) throws UnknownHostException {
        jongo  = new Jongo(mongoTemplate.getDb());
        questioncoll = jongo.getCollection("questionCollection");
    }
    @Override
    public Long getNumberOfQuestions() {
        return questioncoll.count();
    }

    @Override
    public List<Question> getNClassname(int n) {
        Iterable<Question> iterable = questioncoll.find().limit(n).as(Question.class);
        return toList(iterable);
    }

    @Override
    public Question getQuestionByClassName(String classname) {
        Iterable<Question> iterable = questioncoll.find("{'classname': \"" + classname + "\"}").as(Question.class);
        return toList(iterable).get(0);
    }

    @Override
    public List<Question> getAllQuestions() {
        Iterable<Question> iterable = questioncoll.find().as(Question.class);
        return toList(iterable);
    }

    @Override
    @Transactional
    public void save(Question question) {

    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        if(iterable instanceof List) {
            return (List<E>) iterable;
        }
        ArrayList<E> list = new ArrayList<E>();
        if(iterable != null) {
            for(E e: iterable) {
                list.add(e);
            }
        }
        return list;
    }
}
