package com.abelcabral.workshopmongo.services;

import java.util.List;

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
}
