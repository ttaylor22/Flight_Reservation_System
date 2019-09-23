package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.UserProfile;


@Repository
public interface User_ProfileRepository extends JpaRepository<UserProfile, Integer> {
	
}