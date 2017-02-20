package es.uniovi.asw.dbManagement;

import es.uniovi.asw.dbManagement.model.Participant;

public interface ParticipantRepository {

    Participant findByEmail(String email);
}
