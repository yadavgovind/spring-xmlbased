package com.myblog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="users")
public class User {
	
private Long id;
private String username;
private String password;
private String firstName;
private String lastName;
private Boolean enabled;
private String email;
private String pic;
private String aboutMe;
private String confirm;
private String name;







@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password="
			+ password + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", enabled=" + enabled + ", email=" + email + ", pic=" + pic
			+ ", aboutMe=" + aboutMe + ", confirm=" + confirm + "]";
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(Long id, String username, String password, String firstName,
		String lastName, Boolean enabled, String email, String pic,
		String aboutMe, String confirm) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.enabled = enabled;
	this.email = email;
	this.pic = pic;
	this.aboutMe = aboutMe;
	this.confirm = confirm;
}
@Transient
public String getConfirm() {
	return confirm;
}
public void setConfirm(String confirm) {
	this.confirm = confirm;
}
//private Date dateOfBirth;
@GeneratedValue
@Id
@Column(name="id")
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="username",nullable=false)
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Column(name="password")
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Column(name="first_name")
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
@Column(name="last_name")
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
@Column(name="enabled")
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}
@Column(name="email")
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column(name="pic")
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
@Column(name="aboutme")
public String getAboutMe() {
	return aboutMe;
}
public void setAboutMe(String aboutMe) {
	this.aboutMe = aboutMe;
}
@Transient
public String getName()
{ return this.firstName+" "+this.lastName;
}
}
