package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/ServetLogin")/*mapeamento de URL que vem da tela*/
public class ServletLogin  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   
    public ServletLogin() {

        
    }

	
	protected void doGet/*recebe os dadods pela url em parametros*/(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost /*recebe os dadods enviado spor um formualiro*/(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("idade"));
	}

}