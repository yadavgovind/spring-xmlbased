package com.myblog.domain;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.mapping.Map;
@Entity
@Table(name="blog_tbl")
public class Blog {
private Long id;
private String title;
private Long user;
private Date date;
private String content;
private Long catid;
private Map comment;
@Id
@GeneratedValue
@Column(name="blog_id")
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="title")
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}


@Temporal(TemporalType.DATE)
@Column(name="date")
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Column(name="content")
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
@Column(name="category_id")
public Long getCatid() {
	return catid;
}
public void setCatid(Long catid) {
	this.catid = catid;
}
@Column(name="user_id")
public Long getUser() {
	return user;
}
public void setUser(Long user) {
	this.user = user;
}
/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment", nullable = false)
 public Map getComment() {
	return comment;
}
public void setComment(Map comment) {
	this.comment = comment;
}*/








}
