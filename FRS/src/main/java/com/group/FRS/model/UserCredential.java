package com.group.FRS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "user_credential")
public class UserCredential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name="type")
	private String type;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="login_status")
	private boolean loginStatus;
	
	@OneToOne(orphanRemoval = true, 
			fetch = FetchType.EAGER,
			cascade = CascadeType.PERSIST)//orphanRemoval = true,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfile userProfile;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_credential_roles",
            joinColumns = {@JoinColumn(name = "user_credential_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
	private List<Role> roles = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
//	public void addRole(Role r) {
//		
//	}
	@Override
	public String toString() {
		return "UserCredential [id=" + id + ", type=" + type + ", username=" + username + ", password=" + password
				+ ", loginStatus=" + loginStatus + ", userProfile=" + userProfile + "]";
	}
	


}