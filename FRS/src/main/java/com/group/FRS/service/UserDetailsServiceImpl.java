package com.group.FRS.service;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.FRS.model.Role;
import com.group.FRS.model.UserCredential;
import com.group.FRS.repository.User_CredentialRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private User_CredentialRepository userCredentialRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) {
		UserCredential user = userCredentialRepository.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
