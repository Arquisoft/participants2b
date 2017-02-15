package es.uniovi.asw.participants.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.dbManagement.model.Participant;
import es.uniovi.asw.participants.wrappers.LoginWrapper;
import es.uniovi.asw.participants.wrappers.ParticipantInfo;
import es.uniovi.asw.participants.wrappers.UpdateWarpper;

@Controller
@RestController
public class ParticipantController {

    @RequestMapping(value = "/user", produces = {
	    MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE }, consumes = {
		    MediaType.APPLICATION_JSON_VALUE,
		    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ParticipantInfo> queryInfo(
	    @RequestBody @Valid final LoginWrapper login) {

	return new ResponseEntity<ParticipantInfo>(
		new ParticipantInfo(new Participant("Karol", "Ciok", "email")),
		HttpStatus.OK);
    }

    public void updateInfo(UpdateWarpper update) {
	// TODO Auto-generated method stub

    }

}