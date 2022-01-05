package ua.lviv.shved.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.shved.domain.Student;
import ua.lviv.shved.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student create(Student student, MultipartFile file) throws IOException {
		student.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
		student.setFileType(file.getContentType());
		student.setFiledata(file.getBytes());
				
		return studentRepository.save(student);
	}

	public Student findById(int id) {
		return studentRepository.getById(id);
	}
}
