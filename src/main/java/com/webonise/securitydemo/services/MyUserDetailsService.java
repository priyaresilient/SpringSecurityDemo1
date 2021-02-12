package com.webonise.securitydemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webonise.securitydemo.models.UserModel;
import com.webonise.securitydemo.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel user = repo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("Create an account");
		}
		return new UserPrincipal(user);
	}

}
