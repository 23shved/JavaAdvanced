package ua.lviv.shved.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.shved.dao.StudentDao;
import ua.lviv.shved.domain.Student;

@SpringBootApplication

public class Main {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		
		StudentDao studentDao = (StudentDao) context.getBean("student");
		
		studentDao.create(new Student(1, "Oleh", 23));
		studentDao.create(new Student(2, "Anatolii", 25));
		studentDao.create(new Student(3, "Shved", 24));

		studentDao.readAll().stream().forEach(System.out::println);
		System.out.println("---------------");
		
		studentDao.update(new Student(2, "Tolik", 24));
		System.out.println(studentDao.readById(2));
		System.out.println("---------------");
				
		studentDao.delete(1);
		studentDao.readAll().stream().forEach(System.out::println);			
	}

}
