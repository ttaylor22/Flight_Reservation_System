package com.group.FRS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.UserCredential;


@Repository
public interface User_CredentialRepository extends JpaRepository<UserCredential, Integer> {
	
}