package shved.ua.lviv.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import shved.ua.lviv.dao.ProductDao;
import shved.ua.lviv.domain.Product;
import shved.ua.lviv.utils.ConnectionUtil;

public class ProductDaoImpl implements ProductDao{
	
	private static String READ_ALL = "select * from product";
	private static String CREATE = "insert into product(`name`,`description`, `price`) values (?,?,?)";
	private static String READ_BY_ID = "select * from product where id =?";
	private static String UPDATE_BY_ID = "update product set name=?, description = ?, price=?  where id = ?";
	private static String DELETE_BY_ID = "delete from product where id=?";
	
	private static Logger LOG = Logger.getLogger(ProductDaoImpl.class);

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public ProductDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtil.openConnection();
		}
	@Override
	public Product create(Product t) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getDescription());
			preparedStatement.setDouble(3, t.getPrice());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			t.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}
		
		return t;
	}

	@Override
	public Product read(Integer t) {
		
		Product product = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, t);
			ResultSet result = preparedStatement.executeQuery();

			Integer id = result.getInt("id");
			String name = result.getString("name");
			String description = result.getString("description");
			Double price = result.getDouble("price");
			
			product = new Product(id, name, description, price);
			
			
		} catch (SQLException e) {
			LOG.error(e);

		}

		
		return product;
	}

	@Override
	public Product update(Product t) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getDescription());
			preparedStatement.setDouble(3, t.getPrice());
			preparedStatement.setInt(4, t.getId());
		} catch (SQLException e) {
			LOG.error(e);

		}
		return t;
	}
	@Override
	public void delete(Integer t) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, t);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);

		}
			
	}

	@Override
	public List<Product> readAll() {
		List<Product> productRecords = new ArrayList<Product>();
		
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Integer id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Double price = result.getDouble("price");
				
				productRecords.add(new Product(id, name, description, price));
			}
			
			
		} catch (SQLException e) {
			LOG.error(e);

		}
		return productRecords;
	}

}
