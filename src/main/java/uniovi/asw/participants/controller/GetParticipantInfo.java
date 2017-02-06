package uniovi.asw.participants.controller;

import uniovi.asw.participants.model.ParticipantInfo;

public interface GetParticipantInfo {

    ParticipantInfo getPIP(String login, String password);

}
