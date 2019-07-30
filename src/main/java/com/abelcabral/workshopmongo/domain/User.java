package com.abelcabral.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

// Indica que nossa classe se trata de uma coleçao relacionada ao mongoDB, podemos usar
@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	// Em cima do atributo que usamos para identificar a classe o identificamos no caso @Id
	private String id;

	private String name;

	private String email;

	//private List<String> post = new ArrayList<String>();

	public User(String id, String name, String email) {

		this.id = id;

		this.name = name;

		this.email = email;

	}

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

// Para que nossos objetos possam ser comparaveis
	@Override
	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + ((id == null) ? 0 : id.hashCode());

		return result;

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		User other = (User) obj;

		if (id == null) {

			if (other.id != null)

				return false;

		} else if (!id.equals(other.id))

			return false;

		return true;

	}

}
