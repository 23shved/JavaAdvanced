package ua.lviv.shved;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.shved.domain.Customer;
import ua.lviv.shved.service.CustomerService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		CustomerService service = ctx.getBean(CustomerService.class);	
		Customer customer = new Customer();
		customer.setName("Jan");
		customer.setEmail("jan@mail.com");
		customer.setDate(new Date());
		
		// save user to DB
		service.save(customer);
		
		Customer customer2 = new Customer();
		customer2.setName("Jan2");
		customer2.setEmail("jan2@mail.com");
		customer2.setDate(new Date());
		
		// save user to DB
		service.save(customer2);
		
		System.out.println(service.findById((long) 1));
		
		System.out.println(service.findByEmail("jan@mail.com"));
		
		
		Customer forUpdate = service.findById((long) 1);
		forUpdate.setEmail("updatedMail@gmail.com");
		service.update(forUpdate);
		
		System.out.println("After update:");
		System.out.println(service.findById((long) 1));

		
		service.findAll().stream().forEach(System.out::println);
		service.deleteById((long)2);

	}

}
