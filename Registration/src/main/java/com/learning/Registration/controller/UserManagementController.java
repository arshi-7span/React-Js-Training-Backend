package com.learning.Registration.controller;

import com.learning.Registration.entity.User;
import com.learning.Registration.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserManagementController
{
	@Autowired
	UserRegistrationService userRegistrationService;

	@PostMapping(value = "/saveUserRegistration", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User saveUserRegistrationData(@RequestBody User user)
	{
		User userData = userRegistrationService.saveUserRegistrationData(user);
		return userData;
	}

	@GetMapping(value = "/validate-username")
	public boolean validateUsername(@RequestParam String username)
	{
		return userRegistrationService.validateUsername(username);
	}

	@GetMapping(value = "/otp")
	public boolean getOtp(@RequestParam String username, @RequestParam Integer otp)
	{
		return userRegistrationService.getOtp(username,otp);
	}

	@PostMapping(value = {"/change-password"})
	public String changePassword(@RequestParam String username, @RequestParam String password)
	{
		return userRegistrationService.changePassword(username,password);
	}
}
