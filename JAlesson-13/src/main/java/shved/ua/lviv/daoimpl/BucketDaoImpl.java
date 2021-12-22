package shved.ua.lviv.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import shved.ua.lviv.dao.BucketDao;
import shved.ua.lviv.domain.Bucket;
import shved.ua.lviv.domain.Product;
import shved.ua.lviv.shared.FactoryManager;

public class BucketDaoImpl implements BucketDao {
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Bucket create(Bucket t) {
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
	public Bucket read(Integer t) {
		Bucket bucket = null;
		try {
			bucket = em.find(Bucket.class, t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer t) {
		try {
			Bucket bucket =read(t);
			em.getTransaction().begin();
			em.remove(bucket); // persist дозволяє зберігати об`єкт в DB
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Bucket> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Bucket e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (List<Bucket>) query.getResultList();
	
	}

}
