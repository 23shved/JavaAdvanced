package ua.lviv.shved.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.lviv.shved.dao.StudentDao;
import ua.lviv.shved.daoimpl.StudentDaoImpl;


@Configuration
public class Config {
	@Bean (name ="student")
	StudentDao studentDao() {
		return new StudentDaoImpl();
	}
}
