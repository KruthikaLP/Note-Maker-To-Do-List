package com.entities;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "note")
public class Note {
  @Id
  @Column(name = "id")
  private int id;
  @Column(length =1500)
  private String title;
  @Column(name = "content")
  private String content;
  @Column(name = "addedDate")
  private Date addedDate;
  
  
public Note() {
	super();
}

public Note(String title, String content, Date addedDate) {
	super();
	this.id = new Random().nextInt(100000);
	this.title = title;
	this.content = content;
	this.addedDate = addedDate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getAddedDate() {
	return addedDate;
}
public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}

@Override
public String toString() {
	return "Note [id=" + id + ", title=" + title + ", content=" + content + ", addedDate=" + addedDate + "]";
}
  
  
  
}


