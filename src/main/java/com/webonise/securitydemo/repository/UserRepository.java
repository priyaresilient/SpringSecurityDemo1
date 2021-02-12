package com.webonise.securitydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webonise.securitydemo.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	UserModel findByUserName(String userName);
}
