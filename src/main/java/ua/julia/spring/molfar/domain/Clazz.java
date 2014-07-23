package ua.julia.spring.molfar.domain;

import org.jongo.marshall.jackson.oid.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by julia
 */

@Document
public class Clazz {
    @Id
    @ObjectId
    private Integer id;
    private String name;
    private Integer amount;
    private Integer totalAmount;

    @Override
    public String toString() {
        return "Clazz [\n" +
                "\tname : \"" + name + "\"" +
                ",\n\tamount : " + amount +
                ",\n\ttotalAmount : " + totalAmount + "\n" +
                "]";
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
