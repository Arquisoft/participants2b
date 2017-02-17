package es.uniovi.asw.dbManagement;

public class PersistenceFactory {

    public static ParticipantData getParticipantData() {
	return new ParticipantDataImpl();
    }

}
