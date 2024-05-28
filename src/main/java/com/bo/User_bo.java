package com.bo;

public class User_bo {

	private String username,email,city,password;

	public User_bo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User_bo [username=" + username + ", email=" + email + ", city=" + city + ", password=" + password + "]";
	}

	public User_bo(String username, String email, String city, String password) {
		super();
		this.username = username;
		this.email = email;
		this.city = city;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
