package ua.julia.spring.molfar.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Created by julia
 */

@Document
public class Question {
    private Integer id;
    @Indexed(unique = true)
    private String classname;
    private String question;
    private Set<Localization> localization;

    @Override
    public String toString() {
        return "Question [\n" +
                "\tclassname : \"" + classname + "\",\n" +
                "\tquestion : " + question + "\n" +
                "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Localization> getLocalization() {
        return localization;
    }

    public void setLocalization(Set<Localization> localization) {
        this.localization = localization;
    }
}
