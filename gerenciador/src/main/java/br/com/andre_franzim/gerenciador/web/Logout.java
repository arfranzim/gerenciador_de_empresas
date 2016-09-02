package br.com.andre_franzim.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa {

	public String executa(HttpServletRequest req, HttpServletResponse resp){
		req.getSession().removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.jsp";
	}
}
