package ua.lviv.shved;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

	    SessionFactory factory = configuration.buildSessionFactory();


		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();


		
		Post post1 = new Post("post 1");
		
		Comment comment1 = new Comment("comment 1 to post 1");
		comment1.setPost(post1);
		Comment comment2 = new Comment("comment 2 to post 1");
		comment2.setPost(post1);
		Comment comment3 = new Comment("comment 3 to post 1");
		comment3.setPost(post1);
		Comment comment4 = new Comment("comment 3 to post 1");
		comment4.setPost(post1);
						
		post1.setComments(new HashSet<>(Arrays.asList(comment1, comment2, comment3, comment4)));
	

		
		session.persist(post1);		

//		Post post2 = new Post("post 2");
//		
//		Comment comment5 = new Comment("comment 5 to post 2");
//		comment1.setPost(post2);
//		Comment comment6 = new Comment("comment 6 to post 2");
//		comment2.setPost(post2);
//		Comment comment7 = new Comment("comment 7 to post 2");
//		comment3.setPost(post2);
//
//						
//		post2.setComments(new HashSet<>(Arrays.asList(comment5, comment6, comment7)));	
//		
//		session.persist(post2);		
				
		transaction.commit();

		session.close();
	}
}
