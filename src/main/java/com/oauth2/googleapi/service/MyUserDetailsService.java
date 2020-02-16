package com.oauth2.googleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oauth2.googleapi.UserDetailsImpl;
import com.oauth2.googleapi.model.User;
import com.oauth2.googleapi.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = repo.findByUsername(username);
		
		if(user==null)
			throw new UsernameNotFoundException("User 404");

		return new UserDetailsImpl(user);
	}

}
