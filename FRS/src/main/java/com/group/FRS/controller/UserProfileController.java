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
import com.group.FRS.repository.User_CredentialRepository;
import com.group.FRS.repository.User_ProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/userProfile")
public class UserProfileController {

	@Autowired(required=true)
	 User_ProfileRepository userProfileRepository;
	 User_CredentialRepository userCredententialRepository;

    @GetMapping(path="/getAll")
    public List<UserProfile> getAllProfiles(){
        return userProfileRepository.findAll();
    }

    @GetMapping(path="/get/{id}")
    public UserProfile getSingleProfile(@PathVariable(value = "id") int userId) {
    	UserProfile user = userProfileRepository.findById(userId).orElse(null);
    	return user;
    }
    
	@PostMapping(path="/add")
    public ResponseEntity<UserProfile> create( @RequestBody UserProfile user){
		
         return ResponseEntity.ok(userProfileRepository.save(user));
    }
	
	@PostMapping(path="/addById/{id}")
    public ResponseEntity<UserProfile> createWithId( @RequestBody UserProfile user, @PathVariable(value="id")){
		UserCredential user = userCredententialRepository.findById(userId).orElse(null);
         return ResponseEntity.ok(userProfileRepository.save(user));
    }
	
	
	@PutMapping("/update/{id}")
	   public ResponseEntity<UserProfile> updateUserProfile(@PathVariable(value = "id") int userId,
	                                              @Valid @RequestBody UserProfile userDetails) {
	       UserProfile user = userProfileRepository.findById( userId).orElse(null);
	       user.setAddress(userDetails.getAddress());
	       user.setDateOfBirth(userDetails.getDateOfBirth());
	       user.setEmailId(userDetails.getEmailId());
	       user.setGender(userDetails.getGender());
	       user.setMobileNumber(userDetails.getMobileNumber());
	       user.setFirstName(userDetails.getFirstName());
	       user.setLastName(userDetails.getLastName());
	       return ResponseEntity.ok(userProfileRepository.save(user));
	   }
	
	@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
         userProfileRepository.deleteById(id);
    }
}
