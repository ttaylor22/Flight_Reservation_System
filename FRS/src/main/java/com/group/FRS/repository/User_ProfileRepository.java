package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.UserProfile;


@Repository
public interface User_ProfileRepository extends CrudRepository<UserProfile, Long> {
	//
	}
