package shved.ua.lviv.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import shved.ua.lviv.dao.ProductDao;
import shved.ua.lviv.dao.UserDao;
import shved.ua.lviv.daoimpl.ProductDaoImpl;
import shved.ua.lviv.daoimpl.UserDaoImpl;
import shved.ua.lviv.domain.Product;
import shved.ua.lviv.services.ProductService;
import shved.ua.lviv.services.UserService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private static Logger LOG = Logger.getLogger(ProductServiceImpl.class);
	private static ProductService productServiceImpl;

	public ProductServiceImpl() {
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	public static ProductService getProductService() {
		if (productServiceImpl==null) {
			productServiceImpl = new ProductServiceImpl();
		}
		return productServiceImpl;
	}
	@Override
	public Product create(Product t) {
		return productDao.create(t);
	}

	@Override
	public Product read(Integer t) {
		return productDao.read(t);

	}

	@Override
	public Product update(Product t) {
		return productDao.update(t);

	}

	@Override
	public void delete(Integer t) {
		productDao.delete(t);

	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

}
