package shved.ua.lviv.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import shved.ua.lviv.dao.ProductDao;
import shved.ua.lviv.domain.Product;
import shved.ua.lviv.shared.FactoryManager;

public class ProductDaoImpl implements ProductDao {
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Product create(Product t) {
		try {
			em.getTransaction().begin();
			em.persist(t); // persist дозволяє зберігати об`єкт в DB
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public Product read(Integer t) {
		Product product = null;
		try {
			product = em.find(Product.class, t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product update(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Product e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<Product>) query.getResultList();
	}

}
