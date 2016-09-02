package br.com.andre_franzim.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.andre_franzim.gerenciador.Empresa;
import br.com.andre_franzim.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa {
	
	public String executa(HttpServletRequest req, HttpServletResponse resp){

		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		req.setAttribute("empresa", empresa);
 		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
}
