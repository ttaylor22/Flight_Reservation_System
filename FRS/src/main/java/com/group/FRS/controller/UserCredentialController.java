package com.group.FRS.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.FRS.model.Flight;
import com.group.FRS.model.FlightSchedule;
import com.group.FRS.model.PassengerSchedule;
import com.group.FRS.model.Role;
import com.group.FRS.model.UserCredential;
import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.UserCredentialRepository;
import com.group.FRS.repository.UserProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserCredentialController {
	@Autowired
	UserCredentialRepository userCredentialRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;

	@GetMapping("/user/credentials")
	public List<UserCredential> getAllUserCredentials() {
		return userCredentialRepository.findAll();
	}

	@GetMapping("/user/credential/{id}")
	public UserCredential getUserCredential(@PathVariable(value = "id") Long credentialId) {
		UserCredential userCredential = userCredentialRepository.findById(credentialId).orElse(null);
		return userCredential;
	}

	@PostMapping("/user/credential")
	public ResponseEntity<UserCredential> create(@RequestBody UserCredential userCredential) {
		return ResponseEntity.ok(userCredentialRepository.save(createOneToMany(userCredential)));
	}
	
	public static UserCredential createOneToMany(UserCredential userCredential) {
		UserCredential uC = new UserCredential(); 
		uC.setPassword(userCredential.getPassword());
		uC.setType(userCredential.getType());
		uC.setUsername(userCredential.getUsername());
		uC.setLoginStatus(userCredential.isLoginStatus());
		
		uC.setUserProfile(UserProfileController.createOneToMany(userCredential.getUserProfile()));
		
		uC.setRoles(userCredential.getRoles());
//		for(Role r: userCredential.getRoles()) {
//			uC.addRole(r);
//		}
		return uC;
	}
	

	@PutMapping("/user/credential/{id}")
	public ResponseEntity<UserCredential> updateCredentials(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody UserCredential userCredentialDetails) {
		UserCredential userCredential = userCredentialRepository.findById(userId).orElse(null);
		userCredential.setPassword(userCredentialDetails.getPassword());
		userCredential.setType(userCredentialDetails.getType());
		userCredential.setUsername(userCredentialDetails.getUsername());
		userCredential.setLoginStatus(userCredentialDetails.isLoginStatus());
		final UserCredential updateduserCredential = userCredentialRepository.save(userCredential);
		return ResponseEntity.ok(updateduserCredential);
	}
	
	@PutMapping("/user/credential/{id1}/user/profile/{id2}/")
	public ResponseEntity<UserCredential> connect(@PathVariable(value = "id1") Long id1,
			@PathVariable(value = "id2") Long id2,
			@Valid @RequestBody UserProfile userDetails) {
		UserCredential userC = userCredentialRepository.findById(id1).orElse(null);
		UserProfile user = userProfileRepository.findById(id2).orElse(null);
		userC.setUserProfile(user);
		return ResponseEntity.ok(userCredentialRepository.save(userC));
	}

	@DeleteMapping("/user/credential/{id}")
	public void delete(@PathVariable("id") Long id) {
		userCredentialRepository.deleteById(id);
	}
	

}
