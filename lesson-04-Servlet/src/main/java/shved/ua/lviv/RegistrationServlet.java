package shved.ua.lviv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email + password);
		
		userServices.saveUser(new User(firstName, lastName, email, password));
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);

		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}
