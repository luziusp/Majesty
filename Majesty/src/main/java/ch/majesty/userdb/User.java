package ch.majesty.userdb;
/*
 * PLU  31.10.2018
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@Column(nullable = false, unique = true)
	private String login;
	private String password;
	private int wins;
	private int losses;


public User(String log, String pw, int w, int l) {
	this.password = pw;
	this.login = log;
	this.wins = w;
	this.losses = l;
}
}
