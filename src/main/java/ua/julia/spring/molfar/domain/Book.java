package ua.julia.spring.molfar.domain;

import org.jongo.marshall.jackson.oid.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by julia
 */

@Document
public class Book{
    @Id @ObjectId
    private Integer id;
    private String title;
    private String writer;
    private Integer priority = 100;
    private Integer year;
    @Transient
    private Double result;
    private Set<Clazz> clazzList = new HashSet<Clazz>();

    @Override
    public String toString() {
        String s = "Book [\n" +
                "\ttitle : \"" + title + "\"" +
                ",\n\twriter : \"" + writer  + "\"" +
                ",\n\tyear : " + year  +
                ",\n\tpriority : " + priority  +
                ",\n\tclazz : [\n" + clazzList.toArray()[0];

        for (int i = 1; i < clazzList.size(); i++) {
            s += ",\n" + clazzList.toArray()[i];
        }


        s += "]\n]";
        return s;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Set<Clazz> getClazzList() {
        return clazzList;
    }

    public void setClazzList(Set<Clazz> clazzList) {
        this.clazzList = clazzList;
    }

}
