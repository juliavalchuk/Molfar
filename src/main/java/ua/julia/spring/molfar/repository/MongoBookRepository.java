package ua.julia.spring.molfar.repository;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.julia.spring.molfar.domain.Book;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia
 */
@Repository
@Service(value = "bookRepository")
public class MongoBookRepository implements BookRepository{

    Jongo jongo;
    MongoCollection bookcoll;

    @Autowired
    public MongoBookRepository(MongoTemplate mongoTemplate) throws UnknownHostException {
        jongo  = new Jongo(mongoTemplate.getDb());
        bookcoll = jongo.getCollection("bookCollection");
    }

    @Override
    public Long getNumberOfBook() {
        return bookcoll.count();
    }

    @Override
    public List<Book> getAllBoks() {

        Iterable<Book> iterable = bookcoll.find().as(Book.class);
        return toList(iterable);
    }

    @Override
    public List<Book> findToClazz(String classname) {
        Iterable<Book> iterable = bookcoll.find("{'clazzList.name': \"" + classname + "\"}").as(Book.class);
        return toList(iterable);
    }

    @Override
    @Transactional
    public void save(Book book) {

        bookcoll.save(book);

    }

//    Iterable<Friend> all = friends.find("{name: 'Joe'}").as(Friend.class);
//    Friend one = friends.findOne("{name: 'Joe'}").as(Friend.class);

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
