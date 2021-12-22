package shved.ua.lviv.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shved.ua.lviv.domain.Bucket;
import shved.ua.lviv.domain.Product;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.serviceimpl.BucketServiceImpl;
import shved.ua.lviv.serviceimpl.ProductServiceImpl;
import shved.ua.lviv.serviceimpl.UserServiceImpl;
import shved.ua.lviv.services.BucketService;
import shved.ua.lviv.services.ProductService;
import shved.ua.lviv.services.UserService;

/**
 * Servlet implementation class BucketController
 */
@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private	BucketService bucketService = BucketServiceImpl.getBucketService();
	private ProductService productService = ProductServiceImpl.getProductService();
	private UserService userService = UserServiceImpl.getUserService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");
		Product product = productService.read(Integer.parseInt(productId));
		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");
		User user = userService.read(userId);


		Bucket bucket = new Bucket();
		bucket.setId(UUID.randomUUID().toString());
		bucket.setProduct(product);
		bucket.setUser(user);
		bucket.setPurchaseDate(new Date());
		
		
		bucketService.create(bucket);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
}
