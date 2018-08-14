package com.klcm.news.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.klcm.news.dao.KindDao;
import com.klcm.news.dao.NewsDao;
import com.klcm.news.pojo.Kind;
import com.klcm.news.pojo.Message;
import com.klcm.news.pojo.News;
import com.klcm.news.service.NewsService;
import com.klcm.news.utils.UpUtils;

@Service
@Transactional

public class NewsServiceImpl implements NewsService {
	
	@Resource
	private NewsDao newsDao;
	
	@Resource
	private KindDao kindDao;

	public List<News> findAll() {
		// TODO Auto-generated method stub
		return newsDao.findAll();
	}

	public List<News> findByLike(String title) {
		// TODO Auto-generated method stub
		return newsDao.findByLike(title);
	}

	public Message addNews(News news, String type, MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		Kind kind = kindDao.findByType(type);
		if (kind!=null) {			
			News news1=newsDao.findByTitle(news.getTitle());
			if (news1==null) {
				
				String id=UUID.randomUUID().toString().substring(0,4);
			    news.setId(id);
			    news.setKind(kind);			    
			    if (file.getSize()>0) {
					String imgPath= UpUtils.upfile(file, request);
				    news.setAddress(imgPath);
				}else {
					news.setAddress("");
				}
				
				newsDao.addNews(news);
				 msg.setMsg("添加成功！");
				 return msg;
			
			   }else {
				   
				    msg.setMsg("该新闻已经存在，请勿重复添加！");
				    return msg;
			}
		}else {
			msg.setMsg("该新闻类型不存在");
			return msg;
		}		
	}
	
	public Message updateNews(News news, String type,MultipartFile file,HttpServletRequest request) {
		// TODO Auto-generated method stub
		Message msg =new Message();
		Kind kind = kindDao.findByType(type);
		if (kind!=null) {
			News news1 = newsDao.findById(news.getId());
			if (news1!=null) {
				news.setKind(kind);
				if (file.getSize()>0) {
					String imgPath= UpUtils.upfile(file, request);
				    news.setAddress(imgPath);
				}else {
					news.setAddress(news1.getAddress());
				}
				newsDao.updateNews(news);
				msg.setMsg("修改成功！");
				return msg;
			}else {
				msg.setMsg("该新闻不存在！");
				return msg;
			}
		}else {
			msg.setMsg("该新闻类型不存在！");
			return msg;
		}

		
	}

	public Message deleteById(String nId) {
		// TODO Auto-generated method stub
		Message msg = new Message();
		News news = newsDao.findById(nId);
		if (news!=null) {
			newsDao.deleteById(news);
			msg.setMsg("删除成功！！！");
			return msg;
		}else {
			msg.setMsg("该对象已经被删除！");
			return msg;
		}
	}	


	

}