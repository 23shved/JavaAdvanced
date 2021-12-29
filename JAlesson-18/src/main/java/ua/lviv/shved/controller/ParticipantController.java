package ua.lviv.shved.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.shved.domain.Participant;
import ua.lviv.shved.service.ParticipantService;

@Controller
public class ParticipantController {

	
	@Autowired
	private ParticipantService participantService;

	@GetMapping("/")
	public String init(HttpServletRequest request) {
		request.setAttribute("participants", participantService.findAll());
		request.setAttribute("mode", "VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newBook(HttpServletRequest request) {
		request.setAttribute("mode", "CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, HttpServletRequest request) {
		participantService.update(participant);
		request.setAttribute("participants", participantService.findAll());
		request.setAttribute("mode", "VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam Integer id, HttpServletRequest request) {
		request.setAttribute("participant", participantService.findById(id));
		request.setAttribute("mode", "EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam Integer id, HttpServletRequest request) {
		participantService.deleteById(id);
		request.setAttribute("participants", participantService.findAll());
		request.setAttribute("mode", "VIEW");
		return "index";
	}
}
