package ua.lviv.shved.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.shved.domain.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>  {

}
