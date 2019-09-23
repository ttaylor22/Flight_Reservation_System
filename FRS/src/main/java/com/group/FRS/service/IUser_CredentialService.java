package com.group.FRS.service;

import java.util.List;
import com.group.FRS.model.*;

public interface IUser_CredentialService {
	
	void save(UserCredential userCredential);
	UserCredential findByUsername(String username);
	
//	List<UserCredential> find_All();
	
}
