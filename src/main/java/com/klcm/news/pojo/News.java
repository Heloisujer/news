package com.klcm.news.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * 新闻具体信息
 * @author 王雨婷
 *
 */
@Entity
@Table(name="news")
public class News implements Serializable{
	   @Id
	   @Column (length=20)
	   private String id;
	   
	   @Column (length=20)
	   private String title; 
	     
	   
	   @Column (length=20)
	   private String author;
	   
	   @Column (length=500)
	   private String cont;
	   
	   @Column (length=100)
	   private String address;
	   
	   @Column (length=100)
	   private String pubtime;
	   
	   @ManyToOne
	   @JoinColumn(name="kind_id")
	   private Kind kind;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}
	   
	   
	   
	
  
}