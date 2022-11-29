package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

//o chamado Controller sao as servlets ou ServletsLoginController
@WebServlet (urlPatterns = {"/principal/ServletLogin"})/*mapeamento de URL que vem da tela*/
public class ServletLogin  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   
    public ServletLogin() {

        
    }

	
	protected void doGet/*recebe os dadods pela url em parametros*/(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost /*recebe os dadods enviado spor um formualiro*/(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		
		
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			if(modelLogin .getLogin().equalsIgnoreCase("admin")
				&& modelLogin.getSenha().equalsIgnoreCase("admin")) { //simulando login
				
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				
				if (url==null || url.equals("null")) {
					url = "principal/principal.jsp";
					
				}
				
				RequestDispatcher redirecionar = request.getRequestDispatcher(url);//redireciona para o principal
				redirecionar.forward(request, response);
				
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");//volta para o index
				request.setAttribute("msg", "Informe Login e senha corretamente!");
				redirecionar.forward(request, response);
			}
			
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe Login e senha corretamente!");
			redirecionar.forward(request, response);
		
		}
		
	}

}
