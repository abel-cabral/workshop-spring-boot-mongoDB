package com.abelcabral.workshopmongo.repository;

import com.abelcabral.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Com essa interface ja garantimos que poderemos implementar uma série de serviços relacionados a consulta de dados no BD
public interface PostRepository extends MongoRepository<Post, String> { // Espera receber a classe que ira gerenciar e qual é o tipo do Id da classe

}
