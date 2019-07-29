package com.abelcabral.workshopmongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abelcabral.workshopmongo.domain.User;

@RestController // Para dizer que é uma classe que utilizara recurso rest precisamos usar
@RequestMapping(value="/users") // Nome da rota, normalemnte plural
public class UserResource {
	
	@GetMapping // Informamos qual método de acesso a essa funcaono caso um Get
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<User>();
		list.add(new User("1", "Regina Casé", "regininha@globo.com"));
		list.add(new User("3", "Paulo Saulo", "saulo@bol.com"));
		
		return ResponseEntity.ok().body(list);		// Formatamos nossa resposta para uma versao mais sofisticada
	}
}
