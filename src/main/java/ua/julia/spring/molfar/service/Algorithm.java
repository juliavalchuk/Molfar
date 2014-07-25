package ua.julia.spring.molfar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.julia.spring.molfar.domain.Book;
import ua.julia.spring.molfar.domain.Clazz;
import ua.julia.spring.molfar.domain.Question;
import ua.julia.spring.molfar.domain.TableClass;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by julia
 */

/* set init value
 * get first question
  * getquestion(answer)
  * if(getquestion == null)
    * getresult()

*/

@Scope("session")
@Service
public class Algorithm {

    protected BookService bookService;
    protected QuestionService questionService;
    protected List<Book> books;
    protected Map<String, TableClass> mapClasses = new HashMap<>();
    protected List<Book> resultset = new ArrayList<>();
    protected Double PA;
    protected final int P = 5;
    protected final int M = 5;
    protected final int N = 5;
    protected final int K = 5;
    protected int k = 0;
    protected int currQuestion = 1;
    protected String currClassname;
    protected final int QUESTIONLIMIT = 30;


    @Autowired
    public Algorithm(BookService bookService, QuestionService questionService) {
        this.bookService = bookService;
        this.questionService = questionService;

    }

    protected void getBooks(){
        books = bookService.getAllBoks();
    }

    protected void getQuestions(){
        List<Question> questions = questionService.getAllQuestions();
        if(mapClasses != null){
            mapClasses.clear();
        }
        for (Question question : questions) {
            mapClasses.put(question.getClassname(), new TableClass());
        }
    }

    protected void setPAForBooks(){
        int sum = books.stream()
                .map(b -> b.getPriority())
                .reduce(0, Integer::sum);

        for (Book book : books) {
            PA = book.getPriority() * 1. / sum;
            book.setResult(PA);
        }
    }

    protected void setResultset(){
        resultset = books.stream().limit(M).collect(Collectors.toList());
    }

    public void setInitialValue(){

        getBooks();

        setPAForBooks();

        sortBooks();

        setResultset();

        getQuestions();

        currQuestion = 1;
        k = 0;

    }

    protected String getRNDClassName(){
        int n = mapClasses.size();

        return mapClasses.keySet().toArray(new String[n])[(int) (Math.random() * n)];
    }

    public Question getQuestion(){
        String classname = getRNDClassName();
        mapClasses.get(classname).setUsed(true);

        return questionService.getQuestionByClassName(classname); // 1. question?
    }

    public Question getQuestion(Integer answer){
        count(answer);
        check();

        currQuestion++;
        currClassname = getClassname();

        if(k < K && currQuestion <= QUESTIONLIMIT && currClassname.length() > 0){
            return questionService.getQuestionByClassName(currClassname);
        }

        return null; // null if end
    }

    public List<Book> getResult(){
        return books.stream().limit(N).collect(Collectors.toList());
    }

    private void count(int answer){
        List<Book> listByClazz = bookService.findToClazz(currClassname);
        double PB = countPBYes(listByClazz, currClassname);
        if (answer == 1) {
            bayesPBYes(PB, currClassname);
        } else if (answer == 2) {
            bayesPBNo(1 - PB, currClassname);
        }
    }


    private void check() {
        boolean flag = false;
        List<String>  tmp = books.stream()
                .limit(M)
                .map(b -> b.getTitle())
                .collect(Collectors.toList());

        for (Book book : resultset) {
            if(!tmp.contains(book.getTitle().intern())){
                flag = true;
                break;
            }
        }

        if(!flag){
            k++;
        } else {
            k = 0;
        }

        resultset = books.stream()
                .limit(M)
                .collect(Collectors.toList());

    }

    private void bayesPBYes(double PB,String classname){

        double result;
        for (Book book : books) {
            result = book.getClazzList().stream()
                    .filter(c -> c.getName().equals(classname))
                    .mapToDouble(c -> c.getAmount() * 1. / c.getTotalAmount()).sum()
                    * PA / PB;
            book.setResult(book.getResult() + result);
        }

        sortBooks();
    }

    private void bayesPBNo(double PB,String classname){

        double result;
        for (Book book : books) {
            result =(1 - book.getClazzList().stream()
                    .filter(c -> c.getName().equals(classname))
                    .mapToDouble(c -> c.getAmount() * 1. / c.getTotalAmount()).sum())
                    * PA / PB;
            book.setResult(book.getResult() + result);
        }

        sortBooks();
    }

    private double countPBYes(List<Book> list, String classname){
        return list.stream()
                .flatMap(l -> l.getClazzList().stream())
                .filter(c -> c.getName().equals(classname))
                .map(c -> c.getAmount() * 1. / c.getTotalAmount())
                .reduce(0., Double::sum)
                / books.size();
    }

    private String getClassname() { // count priority
        double max = 0.;
        double value = 0.;
        String classname = "";

        for (int i = 0; i < P; i++) {
            Set<Clazz> clazzs = books.get(i).getClazzList();
            for (Clazz clazz : clazzs) {
                TableClass tc = mapClasses.get(clazz.getName());
                if(!tc.isUsed()) {
                    tc.addPriority(clazz.getAmount() * 1. / clazz.getTotalAmount());
                }
            }
        }

        for (Map.Entry<String, TableClass> entry : mapClasses.entrySet()) {
            if(entry.getValue().getPriority() > max){
                max = entry.getValue().getPriority();
                classname = entry.getKey();
            }
            entry.getValue().setPriority(0.);
        }

        try {
            mapClasses.get(classname).setUsed(true);
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return  classname;
    }

    private void sortBooks(){
        books = books.parallelStream()
                .sorted((b1, b2) -> b1.getResult().compareTo(b2.getResult())*(-1))
                .collect(Collectors.toList());
    }
}
