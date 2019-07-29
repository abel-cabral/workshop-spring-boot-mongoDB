package com.abelcabral.workshopmongo.dto;

import com.abelcabral.workshopmongo.domain.User;

import java.io.Serializable;

// Para limitar o que pode ser submetido e aceito em alteraçao
public class UserFromDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;

    public UserFromDTO() {

    }

    public UserFromDTO(User obj) {
        name = obj.getName();
        email = obj.getEmail();
    }

    // Retorna o novo obj para submissao
    public User bodyUserRequest() {
        return new User(null, getName(), getEmail());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
