package ua.lviv.shved.daoimpl;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.shved.dao.StudentDao;
import ua.lviv.shved.domain.Student;

public class StudentDaoImpl implements StudentDao{

	List<Student> students = new ArrayList<>();

	
	@Override
	public Student create(Student student) {
		students.add(student);
		return student;
	}

	@Override
	public Student readById(int id) {
		Student student = students.get(id - 1);
		return student;
	}

	@Override
	public List<Student> readAll() {
		return students;
	}

	@Override
	public Student update(Student student) {
		students.set(student.getId() - 1, student);
		return student;
	}

	@Override
	public void delete(int id) {
		students.remove(id - 1);
		
	}

}
