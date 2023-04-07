package com.learning.Registration.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long Id;
	private String username;
	private String firstname;
	private String lastname;

	public LocalDate getBirthdate()
	{
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate)
	{
		this.birthdate = birthdate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthdate;
	private String password;
	private String gender;
	private String emailId;
	private String country;
	private String state;
	private Integer otp;
}
