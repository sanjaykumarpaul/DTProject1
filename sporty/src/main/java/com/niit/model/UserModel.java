package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {
	@Id
	
	@Column(name="U_MAIL")
	String u_mail;
	@Column(name="U_NAME")
    private String u_name;
	@Column(name="U_AGE")
	private int age;
	@Column (name="U_PHONENO")
	private String phone;
	@Column (name="U_ADDRESS")
	private String address;
	@Column(name="U_PASSWORD")
	private String u_password;
	@Column(name="ROLE")
	private String role;
	@Column(name="enabled")
	private boolean enabled;
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
