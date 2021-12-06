package shved.ua.lviv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserServices userServices = UserServices.getUserServices();
		if (email.equals("admin") && password.equals("admin")) {
			request.getRequestDispatcher("jdbc2").forward(request, response);

		}
		else {
		User user = userServices.getUser(email);
		if (user == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if (user.getEmail().equals("admin")&&user.getPassword().equals("admin")) {
			request.getRequestDispatcher("header.jsp").forward(request, response);
		}
		if (user.getPassword().equals(password)) {
			request.setAttribute("email", email);
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
			
		} else

			request.getRequestDispatcher("index.jsp").forward(request, response);

	}
		}
		

}
