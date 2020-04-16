package aula06;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaisController
 */
@WebServlet("/PaisController.do")
public class PaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		RequestDispatcher dispacher = null;
		
		if(acao.equals("incluir")) {
			String nome = request.getParameter("nome");
			String populacao = request.getParameter("populacao");
			String area = request.getParameter("area");
			
			Pais pais = new Pais();
			pais.setNome(nome);
			pais.setPopulacao(Long.parseLong(populacao));
			pais.setArea(Double.parseDouble(area));
			
			pais.create();
			
			pais.read();
			
			request.setAttribute("pais", pais);
			
			dispacher = request.getRequestDispatcher("Pais.jsp");
			
		}else if(acao.equals("listar")) {
			
			ArrayList<Pais> lista = PaisService.listaPaises();
			
			request.setAttribute("lista", lista);
			
			dispacher = request.getRequestDispatcher("ListaPaises.jsp");
		}
		
		dispacher.forward(request, response);
	}

}
