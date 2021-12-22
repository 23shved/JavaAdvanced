package shved.ua.lviv.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import shved.ua.lviv.dao.UserDao;
import shved.ua.lviv.domain.User;
import shved.ua.lviv.shared.FactoryManager;
import shved.ua.lviv.utils.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public User create(User t) {
		try {
			em.getTransaction().begin();
			em.persist(t); //persist дозволяє зберігати об`єкт в DB
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t; 
	}

	@Override
	public User read(Integer t) {
		User user = null;
		try {
			user = em.find(User.class, t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readByEmail(String email) {
		User user = null;
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> from = criteria.from(User.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("email"), email));
			TypedQuery<User> typed = em.createQuery(criteria);
			user = typed.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}

	
}
