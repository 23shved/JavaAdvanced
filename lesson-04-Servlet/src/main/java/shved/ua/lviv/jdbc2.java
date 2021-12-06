package shved.ua.lviv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc2")
public class jdbc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	String query = null;
	String url = null;
	String username = null;
	String password = null;
	public static Statement st;

	public jdbc2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {

		url = "jdbc:mysql://localhost:3306/librarynew";
		username = "root";
		password = "11111";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		query = "select * from librarynew.data";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			out.println("<html><body><h2>The Select query has following results : </h2>");
			out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
			out.println("<tr>");
			out.println("<td><b>ID</b></td>");
			out.println("<td><b>Book</b></td>");
			out.println("<td><b>Price</b></td>");
			out.println("<td><b>Link</b></td>");
			out.println("</tr>");

			while (resultSet.next()) {
				out.println("<tr>");
				out.println("<td>" + resultSet.getInt(1) + "</td>");
				out.println("<td>" + resultSet.getString(2) + "</td>");
				out.println("<td>" + resultSet.getInt(3) + "</td>");
				out.println("<td>" + resultSet.getString(4) + "</td>");
				out.println("</tr>");

			}
			out.println("</table></br><hr></body></html>");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		try {
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
