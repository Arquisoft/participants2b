package es.uniovi.asw.participants.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.dbManagement.model.Participant;
import es.uniovi.asw.participants.wrappers.ParticipantInfo;

@Controller
@RestController
public class ParticipantController {

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = {
	    MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE }, consumes = {
		    MediaType.APPLICATION_JSON_VALUE,
		    MediaType.APPLICATION_XML_VALUE,
		    MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public ResponseEntity<ParticipantInfo> queryInfo(
	    @RequestBody @Valid final MultiValueMap<String, String> paramMap) {

	if (paramMap == null)
	    return new ResponseEntity<ParticipantInfo>(HttpStatus.BAD_REQUEST);

	return new ResponseEntity<ParticipantInfo>(
		new ParticipantInfo(new Participant("Nombre-Ejemplo",
			"Contraseña-Ejemplo", paramMap.getFirst("login"))),
		HttpStatus.OK);
    }

    @RequestMapping(value = "/changePass", method = RequestMethod.POST, produces = {
	    MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE }, consumes = {
		    MediaType.APPLICATION_JSON_VALUE,
		    MediaType.APPLICATION_XML_VALUE,
		    MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public void updateInfo(
	    @RequestBody @Valid final MultiValueMap<String, String> paramMap) {
	// TODO Auto-generated method stub

    }

}