package es.uniovi.asw.participants.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.dbManagement.model.Participant;
import es.uniovi.asw.participants.wrappers.LoginWrapper;
import es.uniovi.asw.participants.wrappers.ParticipantInfo;
import es.uniovi.asw.participants.wrappers.UpdatePassWrapper;

@Controller
@RestController
public class ParticipantController {
    
    

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<ParticipantInfo> queryInfo(
	    @RequestBody @Valid final LoginWrapper loginWrapper) {

	if (loginWrapper == null)
	    return new ResponseEntity<ParticipantInfo>(HttpStatus.BAD_REQUEST);
	
	

	return new ResponseEntity<ParticipantInfo>(
		new ParticipantInfo(new Participant("Nombre-Ejemplo",
			"Contraseña-Ejemplo", loginWrapper.getLogin())),
		HttpStatus.OK);
    }

    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
    public void updateInfo(
	    @RequestBody @Valid final UpdatePassWrapper updateWrapper) {
	// TODO Auto-generated method stub

    }

}