package com.revature.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "resetToken")
	private String resetToken;
	
//	columnDefinition forces the role to be either MANAGER, CUSTOMER, or VENDOR
	@Column(name="role", columnDefinition = "VARCHAR2(50) CHECK (role IN ('ADMIN', 'QC', 'USER'))")
	private String role;
	
	
public User() { }

public User(String email) {
	this.email=email;
}

public User(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}


//public User(String resetToken) {
//	super();
//	this.resetToken = resetToken;
//}


public User(long id, String email, String password, String firstName, String lastName, Date createdDate,
		String resetToken, String role) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.createdDate = createdDate;
	this.resetToken = resetToken;
	this.role = role;
}




public long getId() {
	return id;
}




public void setId(long id) {
	this.id = id;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




public String getFirstName() {
	return firstName;
}




public void setFirstName(String firstName) {
	this.firstName = firstName;
}




public String getLastName() {
	return lastName;
}




public void setLastName(String lastName) {
	this.lastName = lastName;
}




public Date getCreatedDate() {
	return createdDate;
}




public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}




public String getResetToken() {
	return resetToken;
}




public void setResetToken(String resetToken) {
	this.resetToken = resetToken;
}




public String getRole() {
	return role;
}




public void setRole(String role) {
	this.role = role;
}




@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
			+ lastName + ", createdDate=" + createdDate + ", resetToken=" + resetToken + ", role=" + role + "]";
}


	
	
}
