package com.learning.Registration.service;

import com.learning.Registration.entity.User;

public interface UserRegistrationService
{
	public User saveUserRegistrationData(User user);
	public boolean validateUsername(String emailId);
	public boolean getOtp(String username, Integer otp);

	public String changePassword(String username,String password);



}
