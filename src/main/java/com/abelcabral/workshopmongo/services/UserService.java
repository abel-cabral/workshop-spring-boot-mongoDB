package com.abelcabral.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.abelcabral.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abelcabral.workshopmongo.domain.User;
import com.abelcabral.workshopmongo.repository.UserRepository;

@Service	// Faz o spring identificar a classe como um serviço
public class UserService{
	@Autowired
	private UserRepository repo;		// Quando usamos a notacao @Autowired o proprio spring ja ira instanciar o obj para nos
	
	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User body) {
		return repo.insert(body);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

}
