package com.chvrg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"*.do"}, name="ControllerServlet")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String appName;

	@Override
	public void init() throws ServletException {
		CssClass css = new CssClass();
		css.setName("bg-info");

//		String [] tabs = {"Sign In", "Home", "Profile", "Settings"};
		
		List<Tab> tabs = new ArrayList<Tab>();
		tabs.add(new Tab("Sign In", "#signin"));
		tabs.add(new Tab("Home", "#home"));
		tabs.add(new Tab("Profile", "#profile"));
		tabs.add(new Tab("Messages", "#messages"));
		tabs.add(new Tab("Settings", "#settings"));
		
		ApplicationSettings as = new ApplicationSettings();
		as.setFormClass(css);
		as.setTabs(tabs);
		
		getServletContext().setAttribute("app", as);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User(); 
		user.setEmail("john@doe.com");
		user.setName("John");
		user.addTodo("Finish course", 1);
		user.addTodo("Go ride your bike", 3);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
		// Global scope
		// getServletContext().setAttribute(arg0, arg1);

		// Session scope
		// req.getSession().setAttribute(arg0, arg1);
		
		// Request scope
		req.setAttribute("user", user);
		dispatcher.forward(req, resp); 
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
