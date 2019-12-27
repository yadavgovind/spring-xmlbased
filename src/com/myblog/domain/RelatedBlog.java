package com.myblog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="related_blog")
public class RelatedBlog {
private Long id;
private Long blogId;
private Long relatedBlogId;
@Id
@GeneratedValue
@Column(name="id",unique=true,nullable=false)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="blog_id",nullable=false)
public Long getBlogId() {
	return blogId;
}
public void setBlogId(Long blogId) {
	this.blogId = blogId;
}
@Column(name="related_blog_id")
public Long getRelatedBlogId() {
	return relatedBlogId;
}
public void setRelatedBlogId(Long relatedBlogId) {
	this.relatedBlogId = relatedBlogId;
}

}
