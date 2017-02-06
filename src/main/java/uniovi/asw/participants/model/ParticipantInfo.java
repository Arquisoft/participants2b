package uniovi.asw.participants.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import uniovi.asw.util.DateUtil;

@XmlRootElement
public class ParticipantInfo {

    private String name;
    private String lastName;
    private Date birthDate;
    private String dni;
    private String email;

    public ParticipantInfo(Participant p) {
	this.name = p.getName();
	this.lastName = p.getLastName();
	this.birthDate = p.getBirthDate();
	this.dni = p.getDni();
	this.email = p.getEmail();
    }

    public String getName() {
	return name;
    }

    public String getLastName() {
	return lastName;
    }

    public Integer getAge() {
	return Period.between(DateUtil.asLocalDate(birthDate), LocalDate.now())
		.getYears();
    }

    public String getDni() {
	return dni;
    }

    public String getEmail() {
	return email;
    }

}