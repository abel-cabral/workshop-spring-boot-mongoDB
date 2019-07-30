package com.abelcabral.workshopmongo.dto;

import com.abelcabral.workshopmongo.domain.Comment;

import java.io.Serializable;

public class CommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    public CommentDTO(Comment obj) {
        setId(obj.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
