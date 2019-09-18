package com.group.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_credential")
public class User_Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_credentials_id;

	private String user_type;
	private int user_id;
	private String password;
	private boolean login_status;

	@OneToOne(mappedBy = "user_credential")
	private User_Profile user_profile;

	public Long getUser_credentials_id() {
		return user_credentials_id;
	}

	public void setUser_credentials_id(Long user_credentials_id) {
		this.user_credentials_id = user_credentials_id;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogin_status() {
		return login_status;
	}

	public void setLogin_status(boolean login_status) {
		this.login_status = login_status;
	}

	public User_Profile getUser_profile() {
		return user_profile;
	}

	public void setUser_profile(User_Profile user_profile) {
		this.user_profile = user_profile;
	}

	@Override
	public String toString() {
		return "User_Credential [user_credentials_id=" + user_credentials_id + ", user_type=" + user_type + ", user_id="
				+ user_id + ", password=" + password + ", login_status=" + login_status + ", user_profile="
				+ user_profile + "]";
	}

}
