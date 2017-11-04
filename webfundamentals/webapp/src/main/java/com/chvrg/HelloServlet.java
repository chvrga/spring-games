package com.chvrg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"}, name="HelloServlet", initParams={@WebInitParam(name="ProductName", value="Inited Web Fundamentals")})
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String appName;

	@Override
	public void init() throws ServletException {
		appName = getServletContext().getInitParameter("ProductName");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if (name != null) {
			resp.setContentType("text/xml");
			resp.getWriter().printf("<application>" + 
									"<name>Hello %s</name>" +
									"<product>%s</product>" +
									"</application>", name, appName);
		} else { 
			throw new ServletException("A name should be entered");		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if (name != null && !name.isEmpty())
			resp.getWriter().printf("Yo there %s!", name);
		else 
			resp.sendRedirect("/WEB-INF/index.jsp");
	}
	
	

}
