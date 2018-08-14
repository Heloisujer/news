package com.klcm.news.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * 新闻分类
 * @author 王雨婷
 *
 */
@Entity
@Table(name="kind")
public class Kind implements Serializable{
	
	private static final long serialVersionUID=1L;
	   @Id
	   @Column (length=20)
	   private String id;
	   
	   @Column (length=20)
	   private String type;
	   
	   @OneToMany(mappedBy="kind")
	   private List<News> news;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}	   	  
}
