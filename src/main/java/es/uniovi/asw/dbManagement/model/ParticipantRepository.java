package es.uniovi.asw.dbManagement.model;

public interface ParticipantRepository {

	Participant getData(String login, String password);
	Participant updateInfo(String login, String password, String newPassword);
}
