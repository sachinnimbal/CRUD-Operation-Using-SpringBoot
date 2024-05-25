package com.crud.entity;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Crud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String about;
	private Date createdDate;
	private Date updatedDate;

	public Crud() {
		// TODO Auto-generated constructor stub
	}

	public Crud(int id, String name, String phone, String about, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.about = about;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAbout() {
		return about;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + phone + " " + createdDate + " " + updatedDate;
	}

}
