package com.abelcabral.workshopmongo.dto;

import com.abelcabral.workshopmongo.domain.Post;

import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Date data;

    public PostDTO() {

    }

    public PostDTO(Post obj) {
        setId(obj.getId());
        setData(obj.getDate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
