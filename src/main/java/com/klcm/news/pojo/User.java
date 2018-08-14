package com.klcm.news.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ”√ªß
 * @author Õı”ÍÊ√
 *
 */
@Entity
@Table(name="user")

public class User implements Serializable{
	   
	private static final long serialVersionUID=1L;
	  
	   @Id
	   @Column (length=20)
	   private String id;
	   
	   @Column (length=20)
	   private String uName;
	   
	   @Column (length=50)
	   private String uPwd;
	   
	   @Column (length=20)
	   private String name;
	   
	   @Column (length=11)
	   private String phone;
	   
	   @Column (length=20)
	   private String email;
	   
	   @Column (length=20)
	   private String job;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}	   	   	
}

