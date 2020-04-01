package Aula03;

import java.io.IOException;
import java.io.PrintWriter;

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
		String nome = request.getParameter("nome");
		String populacao = request.getParameter("populacao");
		String area = request.getParameter("area");

		Pais pais = new Pais();
		pais.setNome(nome);
		pais.setPopulacao(Long.parseLong(populacao));
		pais.setArea(Double.parseDouble(area));
		
		pais.create();
		
		pais.read();
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"Id: "+pais.getId()+"<br>");
		out.println(	"Nome: "+pais.getNome()+"<br>");
		out.println(	"Populacao: "+pais.getPopulacao()+"<br>");
		out.println(	"Area: "+pais.getArea()+"<br>");
	    out.println("</body></html>");
		
	}

}
