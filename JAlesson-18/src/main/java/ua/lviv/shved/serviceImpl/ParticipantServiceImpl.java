package ua.lviv.shved.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.shved.dao.ParticipantRepository;
import ua.lviv.shved.domain.Participant;
import ua.lviv.shved.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService{

	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public Participant create(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public List<Participant> findAll() {
		return participantRepository.findAll();

	}

	@Override
	public Participant findById(Integer id) {
		return participantRepository.getById(id);

	}

	@Override
	public Participant update(Participant participant) {
		return participantRepository.save(participant);

	}

	@Override
	public void deleteById(Integer id) {
		participantRepository.deleteById(id);
		
	}

}
