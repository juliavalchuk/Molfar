package ua.julia.spring.molfar.view;

import org.springframework.stereotype.Service;
import ua.julia.spring.molfar.service.Algorithm;

/**
 * Created by julia
 */

@Service(value = "viewable")
public class ConsoleView {
    private Algorithm algorithm;

//    public int showQuestion(int number, String question) {
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Питання " + number + ". " + question);
//        System.out.println("1. Так");
//        System.out.println("2. Ні");
//        System.out.println("3. Не важливо");
//
//        return in.nextInt();
//    }
//
//
//    public void showResult(List<Book> books) {
//
//        books.stream().forEach(b -> System.out.println("\"" + b.getTitle() + "\" - " + b.getWriter() + ": "
//                + b.getResult() + " (" + b.getYear() + ")"));
//
//    }
}
