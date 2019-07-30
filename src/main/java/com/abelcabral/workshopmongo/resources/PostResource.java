package com.abelcabral.workshopmongo.resources;

import com.abelcabral.workshopmongo.domain.Post;
import com.abelcabral.workshopmongo.dto.PostDTO;
import com.abelcabral.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping("posts/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable("id") String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(new PostDTO(post));
    }
}
