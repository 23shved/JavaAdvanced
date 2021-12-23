package ua.lviv.shved;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();


		Cart cart = new Cart("cart1","cart1_name");
		session.persist(cart);

		Item item1 = new Item("item1");
		Item item2 = new Item("item2");
		Item item3 = new Item("item3");
		Item item4 = new Item("item4");
		cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));

//		session.persist(cart);

		transaction.commit();
		session.close();
	}
	
}