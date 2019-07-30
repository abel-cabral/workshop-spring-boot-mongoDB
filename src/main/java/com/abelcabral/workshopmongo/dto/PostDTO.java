package com.abelcabral.workshopmongo.dto;

import com.abelcabral.workshopmongo.domain.Post;

import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String body;
    private Date data;

    public PostDTO() {

    }

    public PostDTO(Post obj) {
        setTitle(obj.getTitle());
        setBody(obj.getBody());
        setData(obj.getDate());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
