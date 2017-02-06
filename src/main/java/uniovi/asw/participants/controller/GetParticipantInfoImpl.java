package uniovi.asw.participants.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniovi.asw.dbmanagement.GetParticipant;
import uniovi.asw.dbmanagement.GetParticipantImpl;
import uniovi.asw.participants.model.Participant;
import uniovi.asw.participants.model.ParticipantInfo;

@RestController
public class GetParticipantInfoImpl implements GetParticipantInfo {

    @Override
    @RequestMapping(value = "/user", produces = {
	    MediaType.APPLICATION_ATOM_XML_VALUE }, method = RequestMethod.GET)

    public ParticipantInfo getPIP(@RequestParam(value = "login") String login,
	    @RequestParam(value = "password") String password) {
	GetParticipant getP = new GetParticipantImpl();
	Participant p = getP.getPP(login, password);
	return new ParticipantInfo(p);
    }

}