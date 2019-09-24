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
import com.group.FRS.repository.UserCredentialRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserCredentialController {
	@Autowired(required=true)
	 UserCredentialRepository userCredentialRepository;

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
	
	@GetMapping(path="/credentials")
	public List<UserCredential> getAllProfiles(){
		return userCredentialRepository.findAll();
	}

	@GetMapping(path="/credential/{id}")
	public UserCredential getSingleProfile(@PathVariable(value = "id") long userId) {
		UserCredential user = userCredentialRepository.findById(userId).orElse(null);
		return user;
	}
   
	@PostMapping(path="/credential")
	public ResponseEntity<UserCredential> create( @RequestBody UserCredential user) {
        return ResponseEntity.ok(userCredentialRepository.save(user));
	}
	
	@PutMapping("/credential/{id}")
	public ResponseEntity<UserCredential> updateUserCredential(@PathVariable(value = "id") long userId,
	                                              @Valid @RequestBody UserCredential userDetails) {
	    UserCredential user = userCredentialRepository.findById(userId).orElse(null);
	    user.setType(userDetails.getType());
	    return ResponseEntity.ok(userCredentialRepository.save(user));
	}
	
	@DeleteMapping("/credential/{id}")
	public void delete(@PathVariable("id") long id) {
        userCredentialRepository.deleteById(id);
	}
	/*
	@GetMapping(path="/getId")
	public Long getUserCredentialId(@PathVariable(value = "username") String username) {
		UserCredential user = userCredentialRepository.findByUsername(username);
		
	    return user.getId();
	}
	*/
}
