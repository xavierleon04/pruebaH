package com.radioshack.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FiltroAut", urlPatterns = { "*.xhtml" })
public class FiltroAutorizacion implements Filter {
	public FiltroAutorizacion() {
		System.out.println("Creando Filtro");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			System.out.println("try");
			HttpServletRequest reqt = (HttpServletRequest) request;
			System.out.println(reqt);
			HttpServletResponse resp = (HttpServletResponse) response;
			System.out.println(resp);
			HttpSession ses = reqt.getSession(false);
			System.out.println(ses);
			String reqURI = reqt.getRequestURI();
			System.out.println(reqURI);
			if (reqURI.indexOf("/login.xhtml") >= 0 ||reqURI.indexOf("/index.xhtml") >= 0 || (ses != null && ses.getAttribute("usuario") != null)
					|| reqURI.indexOf("/public/") >= 0 || reqURI.contains("javax.faces.resource")) {
				chain.doFilter(request, response);
				System.out.println("if");
			}else {
				resp.sendRedirect(reqt.getContextPath() + "/login.xhtml");
				System.out.println("else");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}


