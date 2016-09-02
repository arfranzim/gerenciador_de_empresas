package br.com.andre_franzim.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.andre_franzim.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("andrefranzim@gmail.com", new Usuario("andrefranzim@gmail.com","franzim"));
		USUARIOS.put("visitante", new Usuario("visitante","visitante"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
