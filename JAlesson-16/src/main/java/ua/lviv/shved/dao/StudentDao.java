package ua.lviv.shved.dao;

import java.util.List;

import ua.lviv.shved.domain.Student;

public interface StudentDao {

	Student create(Student student);
	
	Student readById(int id);
	
	List<Student> readAll();
	
	Student update(Student student);
	
	void delete(int id);
	
}
