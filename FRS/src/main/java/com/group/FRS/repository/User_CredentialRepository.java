package com.group.FRS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group.FRS.model.UserCredential;


@Repository
public interface User_CredentialRepository extends CrudRepository<UserCredential, Long> {
	//
	}
