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
import com.group.FRS.model.UserCredential;
import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.UserCredentialRepository;
import com.group.FRS.repository.UserProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserCredentialController {
	@Autowired(required=true)
	 UserCredentialRepository userCredentialRepository;

	@Autowired
	UserProfileRepository userProfileRepository;
	
	@GetMapping(path="/credentials")
	public List<UserCredential> getAllProfiles(){
		return userCredentialRepository.findAll();
	}

//	@GetMapping(path="/credential/{id}")
//	public UserCredential getSingleProfile(@PathVariable(value = "id") long userId) {
//		UserCredential user = userCredentialRepository.findById(userId).orElse(null);
//		return user;
//	}
	/*
	@GetMapping("/credential/{id}")
	public UserCredential getUserCredential(@PathVariable(value = "id") Long credentialId) {
		UserCredential userCredential = userCredentialRepository.findById(credentialId).orElse(null);
		return userCredential;
	}
	*/
	@GetMapping(path="/credential/{id}")
	public UserCredential getSingleProfile(@PathVariable(value = "id") long userId) {
		UserCredential user = userCredentialRepository.findById(userId).orElse(null);
		return user;
	}
//	@PostMapping(path="/credential")
//	public ResponseEntity<UserCredential> create( @RequestBody UserCredential user) {
//        return ResponseEntity.ok(userCredentialRepository.save(user));
//	}
	
	@PostMapping(path="/credential")
	public ResponseEntity<UserCredential> create(@RequestBody UserCredential userCredential) {
//		System.out.println(userCredential);
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
	
//	@PutMapping("/credential/{id}")
//	public ResponseEntity<UserCredential> updateUserCredential(@PathVariable(value = "id") long userId,
//	                                              @Valid @RequestBody UserCredential userDetails) {
//	    UserCredential user = userCredentialRepository.findById(userId).orElse(null);
//	    user.setType(userDetails.getType());
//	    return ResponseEntity.ok(userCredentialRepository.save(user));
//	}
	/*
	@PutMapping("/credential/{id}")
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
	*/
	@PutMapping("/credential/{id1}/user/profile/{id2}/")
	public ResponseEntity<UserCredential> connect(@PathVariable(value = "id1") Long id1,
			@PathVariable(value = "id2") Long id2,
			@Valid @RequestBody UserProfile userDetails) {
		UserCredential userC = userCredentialRepository.findById(id1).orElse(null);
		UserProfile user = userProfileRepository.findById(id2).orElse(null);
		userC.setUserProfile(user);
		return ResponseEntity.ok(userCredentialRepository.save(userC));
	}
	
	@DeleteMapping("/credential/{id}")
	public void delete(@PathVariable("id") long id) {
        userCredentialRepository.deleteById(id);
	}
	
	@PutMapping(path="/authenticate/{username}/{password}")
	public ResponseEntity<UserCredential> authenticate(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {
		UserCredential user = userCredentialRepository.findByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				user.setLoginStatus(true);
				final UserCredential updatedUserCredential = userCredentialRepository.save(user);
			    return ResponseEntity.ok(updatedUserCredential);
			}
			return null;
		} else {
			return null;
		}
	}
	
	@PutMapping(path="/logout/{id}")
	public ResponseEntity<UserCredential> logout(@PathVariable(value = "id") Long id) {
		UserCredential user = userCredentialRepository.findById(id).orElse(null);
		if (user != null) {
			user.setLoginStatus(false);
			final UserCredential updatedUserCredential = userCredentialRepository.save(user);
			return ResponseEntity.ok(updatedUserCredential);
		} else {
			return null;
		}
	}
	@PutMapping("/credential/{id}")
	public ResponseEntity<UserCredential> updateUserCredential(@PathVariable(value = "id") long userId,
	                                              @Valid @RequestBody UserCredential userDetails) {
	    UserCredential user = userCredentialRepository.findById(userId).orElse(null);
	    user.setType(userDetails.getType());
	    return ResponseEntity.ok(userCredentialRepository.save(user));
	}
	
}
