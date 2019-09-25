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

import com.group.FRS.model.UserCredential;
import com.group.FRS.model.UserProfile;
import com.group.FRS.repository.UserCredentialRepository;
import com.group.FRS.repository.UserProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserProfileController {

	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	UserCredentialRepository userCredentialRepository;


	@GetMapping(path = "/user/profiles")
	public List<UserProfile> getAllProfiles() {
		return userProfileRepository.findAll();
	}

	@GetMapping(path = "/user/profile/{id}")
	public UserProfile getSingleProfile(@PathVariable(value = "id") Long userId) {
		UserProfile user = userProfileRepository.findById(userId).orElse(null);
		return user;
	}

	@PostMapping(path = "/user/profile")
	public ResponseEntity<UserProfile> create(@RequestBody UserProfile user) {
		return ResponseEntity.ok(userProfileRepository.save(user));
	}

	@PutMapping("/user/profile/{id}")
	public ResponseEntity<UserProfile> updateUserProfile(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody UserProfile userDetails) {
		UserProfile user = userProfileRepository.findById(userId).orElse(null);
		user.setAddress(userDetails.getAddress());
		user.setDateOfBirth(userDetails.getDateOfBirth());
		user.setEmailId(userDetails.getEmailId());
		user.setGender(userDetails.getGender());
		user.setMobileNumber(userDetails.getMobileNumber());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		return ResponseEntity.ok(userProfileRepository.save(user));
	}

	@PutMapping("/user/profile/{id}/user/credential/{id2}")
	public ResponseEntity<UserProfile> connect(@PathVariable(value = "id") Long userId,
			@PathVariable(value = "id2") Long userCId,
			@Valid @RequestBody UserProfile userDetails) {
		//Long l1 = new Long(userId);
		//Long l2 = new Long(userCId);
		UserProfile user = userProfileRepository.findById(userId).orElse(null);
		UserCredential userC = userCredentialRepository.findById(userCId).orElse(null);
		user.setUserCredential(userC);
		return ResponseEntity.ok(userProfileRepository.save(user));
	}

	@DeleteMapping("/user/profile/{id}")
	public void delete(@PathVariable("id") Long id) {
		userProfileRepository.deleteById(id);
	}
}