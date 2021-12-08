package shved.ua.lviv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shved.ua.lviv.daoimpl.UserRole;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.serviceimpl.UserServiceImpl;
import shved.ua.lviv.services.UserService;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(!user_name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			userService.create(new User(user_name, email, UserRole.USER.toString(), password));
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("user_name", user_name);

		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}