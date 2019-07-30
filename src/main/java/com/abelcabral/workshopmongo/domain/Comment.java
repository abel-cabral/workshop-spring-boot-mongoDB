package com.abelcabral.workshopmongo.domain;

import com.abelcabral.workshopmongo.dto.AuthorDTO;
import com.abelcabral.workshopmongo.dto.PostDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "comment")  // Relaciona esse obj com a coleçao post no mongo
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String text;
    private Date data;
    private AuthorDTO author;
    private PostDTO post;

    public Comment(String id, String text, Date data, AuthorDTO author, PostDTO post) {
        this.id = id;
        this.text = text;
        this.data = data;
        this.author = author;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return Objects.equals(getId(), comment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
