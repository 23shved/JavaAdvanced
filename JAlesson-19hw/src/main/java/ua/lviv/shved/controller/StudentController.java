package ua.lviv.shved.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.shved.domain.Student;
import ua.lviv.shved.service.StudentService;



@RestController
public class StudentController {

	@Autowired

	StudentService studentService;

	@PostMapping("/register")
	public String uploadFile(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") Integer age,
			@RequestParam("photo") MultipartFile file) throws IOException {
		Student student = new Student(firstName, lastName, age);
		studentService.create(student, file);
			
		return "redirect:/student?id=" + student.getId();
	}
	@GetMapping("/student")
	public String studentForm(@RequestParam("id") Integer id, ModelMap model)
			throws FileNotFoundException, UnsupportedEncodingException {
		byte[] fileBytes = studentService.findById(id).getFiledata();
        byte[] fileEncodeBase64 = Base64.encodeBase64(fileBytes);
        String fileBase64Encoded = new String(fileEncodeBase64, "UTF-8");
    
	    model.addAttribute("student", studentService.findById(id));
		model.addAttribute("photo", fileBase64Encoded);
		return "student";
	}
}
