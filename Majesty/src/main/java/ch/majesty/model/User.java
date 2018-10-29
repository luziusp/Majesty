package ch.majesty.model;

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


public User(String log, String pw) {
	this.password = pw;
	this.login = log;
}
}
