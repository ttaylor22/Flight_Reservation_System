package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.FRS.model.UserProfile;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface User_ProfileRepository extends JpaRepository<UserProfile, Integer> {
	//
	}
