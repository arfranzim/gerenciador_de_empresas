package br.com.andre_franzim.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 6004452202624196903L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		if (tarefa == null) {
			throw new IllegalArgumentException(
					"Voce esqueceu de passar a tarefa!");
		}

		String nomeDaClasse = "br.com.andre_franzim.gerenciador.web." + tarefa;
		try {
			Class<?> tipo = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

}
