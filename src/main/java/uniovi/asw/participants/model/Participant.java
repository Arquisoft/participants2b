package uniovi.asw.participants.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private String address;
    private String nacionality;
    private String dni;

    Participant() {
    }

    public Participant(String name, String lastName, String email) {
	this.name = name;
	this.lastName = name;
	this.email = email;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Date getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getNacionality() {
	return nacionality;
    }

    public void setNacionality(String nacionality) {
	this.nacionality = nacionality;
    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) {
	this.dni = dni;
    }

    public Long getId() {
	return id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dni == null) ? 0 : dni.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Participant other = (Participant) obj;
	if (dni == null) {
	    if (other.dni != null)
		return false;
	} else if (!dni.equals(other.dni))
	    return false;
	return true;
    }

    public String getPassword() {
	return password;
    }

}
