package com.learning.Registration.repo;

import com.learning.Registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepo extends JpaRepository<User,Long>
{
	User findByUsername(String username);
}
