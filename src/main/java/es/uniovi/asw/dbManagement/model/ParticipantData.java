package es.uniovi.asw.dbManagement.model;

import org.springframework.data.repository.CrudRepository;

public interface ParticipantData extends CrudRepository<Participant, Long>{

	Participant findByEmail(String email);
}
