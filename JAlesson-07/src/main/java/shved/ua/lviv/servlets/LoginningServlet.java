package shved.ua.lviv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import shved.ua.lviv.domain.User;
import shved.ua.lviv.dto.UserLogin;
import shved.ua.lviv.serviceimpl.UserServiceImpl;
import shved.ua.lviv.services.UserService;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userService.readByEmail(email);


		if (email.equals("@dmin") && password.equals("admin")) {
			request.getRequestDispatcher("jdbc2").forward(request, response);
		}
		if (user != null && user.getPassword().equals(password)) {
			
			UserLogin userLogin = new UserLogin();
			userLogin.destinationUrl = "cabinet.jsp";
			userLogin.userEmail = user.getEmail();
			
			
		    String json = new Gson().toJson(userLogin);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    
			HttpSession session = request.getSession(true);
			session.setAttribute("name", user.getName());
		}
		}


}
