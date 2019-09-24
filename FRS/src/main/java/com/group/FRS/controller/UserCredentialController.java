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
@RequestMapping("/api")
public class UserCredentialController {
	@Autowired
	UserCredentialRepository userCredentialRepository;

	@GetMapping(path = "/user/credentials")
	public List<UserCredential> getAllUserCredentials() {
		return userCredentialRepository.findAll();
	}

	@GetMapping(path = "/user/credential/{id}")
	public UserCredential getUserCredential(@PathVariable(value = "id") Long credentialId) {
		UserCredential userCredential = userCredentialRepository.findById(credentialId).orElse(null);
		return userCredential;
	}

	@PostMapping(path = "/user/credential")
	public void create(@RequestBody UserCredential userCredential) {
		userCredentialRepository.save(userCredential);
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

	@DeleteMapping("/user/credential/{id}")
	public void delete(@PathVariable("id") Long id) {
		userCredentialRepository.deleteById(id);
	}

}
