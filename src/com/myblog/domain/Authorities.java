package com.myblog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="authorities")
public class Authorities {
private String userName;
private String authority;
@Id
@Column(name="username")
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Column(name="authority")
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}

}
