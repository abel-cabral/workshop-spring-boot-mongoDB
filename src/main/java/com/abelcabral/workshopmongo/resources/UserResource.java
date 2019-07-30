package com.abelcabral.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.abelcabral.workshopmongo.dto.UserFromDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abelcabral.workshopmongo.domain.User;
import com.abelcabral.workshopmongo.dto.UserDTO;
import com.abelcabral.workshopmongo.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController // Para dizer que é uma classe que utilizara recurso rest precisamos usar
public class UserResource {
	
	// Agora instanciamos nosso serviço para ter acesso a seus metodos, o inspring ja cuida de inicializa-lo
	@Autowired
	private UserService service;
	private String id;

	//@GetMapping // Informamos qual método de acesso a essa funcao no caso um Get e a rota
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		
		// Precisamos converter de list User para list UserDTO, percorremos cada elemento preenchendo a lista DTO
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); 		
		
		// Formatamos nossa resposta para uma versao mais sofisticada
		return ResponseEntity.ok().body(listDTO);		
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	@PostMapping("/users")
	ResponseEntity<UserFromDTO> insert(@RequestBody UserFromDTO obj) {
		User user = obj.bodyUserRequest();
		user = service.insert(user);

		// Captura o id gerado pela inserçao
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		// Retorna um 200 com um objeto vazio e no header o endereço do local de origem
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("users/{id}")
	ResponseEntity<User> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();		// Quando a resposta nao tem nada usamos o noContent
	}

	@PutMapping("users/{id}")
	public ResponseEntity<UserDTO> update(@RequestBody User obj, @PathVariable String id) {
		// Precisamos passar para o obj recebido o id da rota
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
