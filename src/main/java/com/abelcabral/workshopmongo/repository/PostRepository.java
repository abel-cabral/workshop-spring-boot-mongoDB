package com.abelcabral.workshopmongo.repository;

import com.abelcabral.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Com essa interface ja garantimos que poderemos implementar uma série de serviços relacionados a consulta de dados no BD
public interface PostRepository extends MongoRepository<Post, String> { // Espera receber a classe que ira gerenciar e qual é o tipo do Id da classe

    // Podemos fazer consultas usando expressoes do proprio mongoDB
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    // Irá fazer uma busca personalizada, ignorando maiusculas e minusculas
    List<Post> findByTitleContainingIgnoreCase(String text);
}
