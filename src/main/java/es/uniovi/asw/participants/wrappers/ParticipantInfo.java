package es.uniovi.asw.participants.wrappers;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.uniovi.asw.dbManagement.model.Participant;

@XmlRootElement
public class ParticipantInfo {

    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String ndi;
    private String email;

    public ParticipantInfo(Participant participant) {
	this.nombre = participant.getNombre();
	this.apellidos = participant.getApellidos();
	this.fechaNacimiento = participant.getFechaNacimiento();
	this.ndi = participant.getNdi();
	this.email = participant.getEmail();
    }

    @XmlElement
    public String getNombre() {
	return nombre;
    }

    @XmlElement
    public String getApellidos() {
	return apellidos;
    }

    @XmlElement
    public Date getFechaNacimiento() {
	return fechaNacimiento;
    }

    @XmlElement
    public String getNdi() {
	return ndi;
    }

    @XmlElement
    public String getEmail() {
	return email;
    }

}