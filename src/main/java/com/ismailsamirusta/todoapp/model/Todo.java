package com.ismailsamirusta.todoapp.model;

import java.util.Date;

import org.springframework.cloud.gcp.data.firestore.Document;

import com.google.cloud.firestore.annotation.DocumentId;

@Document(collectionName = "todoCollection")
public class Todo {
	@DocumentId
	private String id;
	
	private String title;
	
	private String description;
	
	private boolean complete;

	private Date created;
	
	private Date updated;
	
	private Date due;
	
	private String user;
	
	public Todo() {}
	
	public Todo(String title, String description, boolean complete,Date due) {
		this.title = title;
		this.description = description;
		this.complete = complete;
		this.due = due;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
}
