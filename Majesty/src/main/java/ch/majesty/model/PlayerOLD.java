package ch.majesty.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Player")

public class PlayerOLD {

	private String benutzername, passwort;

	public PlayerOLD() {

	}

	public PlayerOLD(String benutzername, String passwort) {
		this.benutzername = benutzername;
		this.passwort = passwort;
	}
	
	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	
	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


}
