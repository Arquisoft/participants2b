package uniovi.asw.dbmanagement;

import uniovi.asw.participants.model.Participant;

public interface GetParticipant {

    Participant getPP(String login, String password);

}
