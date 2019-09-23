package com.group.FRS.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.group.FRS.model.UserCredential;
import com.group.FRS.repository.RoleRepository;
import com.group.FRS.repository.User_CredentialRepository;

@Service
public class UserCredentialServiceImpl implements IUser_CredentialService{
	@Autowired
	private User_CredentialRepository userCredentialRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(UserCredential user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userCredentialRepository.save(user);
	}
	
	@Override
	public UserCredential findByUsername(String username) {
		return userCredentialRepository.findByUsername(username);
	}
}
