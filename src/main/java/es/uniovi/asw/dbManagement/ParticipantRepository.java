package es.uniovi.asw.dbManagement;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.dbManagement.model.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

    Participant findByEmail(String email);
}
