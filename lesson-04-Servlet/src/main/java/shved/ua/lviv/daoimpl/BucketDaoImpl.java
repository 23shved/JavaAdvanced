package shved.ua.lviv.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shved.ua.lviv.dao.BucketDao;
import shved.ua.lviv.domain.Bucket;
import shved.ua.lviv.domain.Product;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.utils.ConnectionUtil;

public class BucketDaoImpl implements BucketDao {
	private static String READ_ALL = "select * from bucket";
	private static String CREATE = "insert into bucket(`user_id`,`product_id`, `purchase_date`) values (?,?,?)";
	private static String READ_BY_ID = "select * from bucket where id =?";
	private static String DELETE_BY_ID = "delete from bucket where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtil.openConnection();
	}

	@Override
	public Bucket create(Bucket t) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, t.getUserId());
			preparedStatement.setInt(2, t.getProductId());
			preparedStatement.setDate(3, new Date(t.getPurchaseDate().getTime()));
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			t.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return t;

	}

	@Override
	public Bucket read(Integer t) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, t);
			ResultSet result = preparedStatement.executeQuery();

			Integer id = result.getInt("id");
			Integer user_id = result.getInt("user_id");
			Integer product_id = result.getInt("product_id");
			Date purchase_date = result.getDate("purchase_date");

			bucket = new Bucket(id, user_id, product_id, purchase_date);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public void delete(Integer t) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, t);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Bucket> readAll() {
		List<Bucket> bucketRecords = new ArrayList<Bucket>();

		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Integer id = result.getInt("id");
				Integer user_id = result.getInt("user_id");
				Integer product_id = result.getInt("product_id");
				Date purchase_date = result.getDate("purchase_date");

				bucketRecords.add(new Bucket(id, user_id, product_id, purchase_date));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bucketRecords;
	}



	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("You cannot update it");

	}

}
