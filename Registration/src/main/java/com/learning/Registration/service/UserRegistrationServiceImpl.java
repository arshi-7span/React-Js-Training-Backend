package com.learning.Registration.service;

import com.learning.Registration.entity.User;
import com.learning.Registration.repo.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService
{
	@Autowired
	UserRegistrationRepo userRegistrationRepo;

	@Override
	public User saveUserRegistrationData(User user)
	{
		return userRegistrationRepo.save(user);
	}

	@Override
	public boolean validateUsername(String username)
	{
		Random random=new Random();

		User user = userRegistrationRepo.findByUsername(username);
		if(Objects.nonNull(user))
		{
			Integer otp = random.nextInt(100000);
			user.setOtp(otp);
			userRegistrationRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean getOtp(String username, Integer otp)
	{
		User user = userRegistrationRepo.findByUsername(username);
		if(Objects.nonNull(user))
			return Objects.equals(otp, user.getOtp());
		return false;
	}

	@Override
	public String changePassword(String username,String password)
	{
		User user = userRegistrationRepo.findByUsername(username);
		if(Objects.nonNull(user))
		{
			user.setPassword(password);
			userRegistrationRepo.save(user);
			return "User: "+username+" password has been changed successfully";
		}
			return "No user found";
	}
}
