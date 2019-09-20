package com.group.FRS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.User_ProfileRepository;
@Service
public class User_ProfileService implements IUser_ProfileService{
	@Autowired
	private User_ProfileRepository repository;
	
	@Override
	public List<UserProfile> findAll() {
		return (List<UserProfile>) repository.findAll();
	}

}
