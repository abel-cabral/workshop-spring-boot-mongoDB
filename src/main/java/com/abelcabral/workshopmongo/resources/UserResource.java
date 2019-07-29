package com.abelcabral.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abelcabral.workshopmongo.domain.User;
import com.abelcabral.workshopmongo.dto.UserDTO;
import com.abelcabral.workshopmongo.services.UserService;

@RestController // Para dizer que é uma classe que utilizara recurso rest precisamos usar
public class UserResource {
	
	// Agora instanciamos nosso serviço para ter acesso a seus metodos, o inspring ja cuida de inicializa-lo
	@Autowired
	private UserService service;
	
	//@GetMapping // Informamos qual método de acesso a essa funcao no caso um Get e a rota
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		
		// Precisamos converter de list User para list UserDTO, percorremos cada elemento preenchendo a lista DTO
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); 		
		
		// Formatamos nossa resposta para uma versao mais sofisticada
		return ResponseEntity.ok().body(listDTO);		
	}
}
