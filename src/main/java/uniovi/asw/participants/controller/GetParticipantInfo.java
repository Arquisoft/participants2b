package uniovi.asw.participants.controller;

import org.springframework.http.ResponseEntity;

import uniovi.asw.participants.model.Participant;

public interface GetParticipantInfo {

    ResponseEntity<Participant> getPIP(String login, String password);

}
