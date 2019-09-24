package com.group.FRS.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.group.FRS.model.Reservation;
import com.group.FRS.model.UserCredential;
import com.group.FRS.repository.User_CredentialRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserCredentialController {
	@Autowired
	User_CredentialRepository userCredentialRepository;
	
	@PutMapping(path="/authenticate/{username}/{password}")
//	public ResponseEntity<UserCredential> authenticate(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password, @Valid @RequestBody UserCredential userCredential) {
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
//			final UserCredential userNotFound = new UserCredential();
//			HttpHeaders responseHeaders = new HttpHeaders();
//			return ResponseEntity.ok().headers(responseHeaders).body(userNotFound);
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

	//@RequestMapping(path="/", produces="application/json", method=RequestMethod.GET)
   @GetMapping(path="/getAll",  produces="application/json")
   public List<UserCredential> getAllUserCredentials(){
       return userCredentialRepository.findAll();
   }
   
   @GetMapping(path="/get/{id}")
   public UserCredential getSingleCredential(@PathVariable(value = "id") Long credentialId) {
	   UserCredential userCredential = userCredentialRepository.findById(credentialId).orElse(null);
   	return userCredential;
   }

	@PostMapping(path="/add")
   public void create( @RequestBody UserCredential userCredential){
        userCredentialRepository.save(userCredential);
   }
	
	@PutMapping("/update/{id}")
	   public ResponseEntity<UserCredential> updateCredentials(@PathVariable(value = "id") Long userId,
	                                              @Valid @RequestBody UserCredential userCredentialDetails) {
	       UserCredential userCredential= userCredentialRepository.findById( userId).orElse(null);
	       userCredential.setPassword(userCredentialDetails.getPassword());
	       userCredential.setType(userCredentialDetails.getType());
	       userCredential.setUsername(userCredentialDetails.getUsername());
	       userCredential.setLoginStatus(userCredentialDetails.isLoginStatus());
	       final UserCredential updatedUserCredential = userCredentialRepository.save(userCredential);
	       return ResponseEntity.ok(updatedUserCredential);
	   }
	
	@DeleteMapping("/delete/{id}")
   public void delete(@PathVariable("id") Long id) {
        userCredentialRepository.deleteById(id);
   }
   
}