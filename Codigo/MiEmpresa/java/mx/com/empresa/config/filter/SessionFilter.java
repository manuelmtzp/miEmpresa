package mx.com.empresa.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.com.royalsun.security.vo.SessionAccount;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest  request  = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//ServletContext      servletContext = servletRequest.getServletContext();
		
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			response.sendRedirect( request.getContextPath() );
		} else {
			
			SessionAccount account = (SessionAccount) session.getAttribute("sessionAccount");
			if (account != null && account.getUsuario() != null) {
				if (filterChain != null) {
					filterChain.doFilter(request, response);
				}
			} else {
				response.sendRedirect(request.getContextPath());
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
