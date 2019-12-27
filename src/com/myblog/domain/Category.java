package com.myblog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="category")
public class Category {
private Long id;
private String name;


@Id
@GeneratedValue
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="name")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



}
