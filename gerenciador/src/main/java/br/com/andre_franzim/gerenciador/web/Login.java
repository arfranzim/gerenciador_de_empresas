package br.com.andre_franzim.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.andre_franzim.gerenciador.Usuario;
import br.com.andre_franzim.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa {

	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if (usuario != null) {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(10 * 60);
			session.setAttribute("usuarioLogado", usuario);
			req.setAttribute("usuario", usuario);
			return "/WEB-INF/paginas/login.jsp";
		}
		
		req.setAttribute("resultado",  "Usuario ou Senha incorretos");
		return "/WEB-INF/paginas/login.jsp";
	}

}
