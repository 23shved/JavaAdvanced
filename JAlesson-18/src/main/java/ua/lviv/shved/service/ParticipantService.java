package ua.lviv.shved.service;

import java.util.List;

import ua.lviv.shved.domain.Participant;

public interface ParticipantService {
	Participant create(Participant participant);

	List<Participant> findAll();
	
	Participant findById(Integer id);

	Participant update(Participant participant);

	void deleteById(Integer id);
}
