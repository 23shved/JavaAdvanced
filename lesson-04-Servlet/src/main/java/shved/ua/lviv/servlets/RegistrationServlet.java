package shved.ua.lviv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shved.ua.lviv.domain.User;
import shved.ua.lviv.services.UserServices;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServices userServices = UserServices.getUserServices();
	public RegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String password = request.getParameter("password");
		System.out.println(email + password);
		
		userServices.saveUser(new User(name, email, role, password));
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		session.setAttribute("user_name", name);
		session.setAttribute("role", role);

		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}
