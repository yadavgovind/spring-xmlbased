package com.myblog.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="blog_tbl")
public class NewBlog {
	
	
	private Long blogId;
	private String title;
	private String content;
	private Long categoryId;
	private Date date;
	private Long userId;
	private String blogMeta;
	
	@Id
	@GeneratedValue
	@Column(name="blog_id",nullable=false, unique=true)
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="category_id")
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name="user_id")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(name="blog_meta")
	public String getBlogMeta() {
		return blogMeta;
	}
	public void setBlogMeta(String blogMeta) {
		this.blogMeta = blogMeta;
	}
	

}
