package ua.julia.spring.molfar.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

/**
 * Created by julia
 */

@Document
public class Account {
    @Id
    @Email(message = "{form.validation.emal.error}")
    private String username;
    @Size(min=6, max=30, message = "{form.validation.password.size}")
    private String password;
    @Transient
    private String confirmPassword;

    public Account() {
    }
}
