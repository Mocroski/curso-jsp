package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/principal/*"}) //Intercepta todas as requicisoes que vierem do projeto ou mapemaento
public class FilterAutenticacao extends HttpFilter implements Filter {
       
    
    public FilterAutenticacao() {
        super();
    }

	
	public void destroy() {//encerra os processos quando o servido é parado
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {//intercepsta todas as requisicoes e da as respostas no sistema
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");
		
		String urlParaAutenticar = req.getServletPath();//url que esta sendo acessada
		
		//validar se esta logado senao redireciona par a atela de login
		
		if(usuarioLogado == null || (usuarioLogado != null && usuarioLogado.isEmpty()) && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")
			
			/*&& !urlParaAutenticar.equalsIgnoreCase("/ServletLogin")*/ ) {//nao esta logado
			
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login");
			redireciona.forward(request, response);
			return; //para a execucao e redireciona para o login
		}else {
			chain.doFilter(request, response);
			
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {//inicia os processos ou recursos quando o servidor sobe o prjeto
	}

}
