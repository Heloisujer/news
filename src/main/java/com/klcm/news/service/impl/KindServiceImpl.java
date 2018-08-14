package com.klcm.news.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.klcm.news.dao.KindDao;
import com.klcm.news.dao.NewsDao;
import com.klcm.news.pojo.Kind;
import com.klcm.news.pojo.Message;
import com.klcm.news.pojo.News;
import com.klcm.news.service.KindService;

/**
 * 新闻分类服务层
 * @author 王雨婷
 *
 */
@Service
@Transactional
public class KindServiceImpl  implements KindService{
	
	@Resource
	private KindDao kindDao;
	
	@Resource
	private NewsDao newsDao;

	public List<Kind> findAll() {
		// TODO Auto-generated method stub
		List<Kind> kinds=kindDao.findAll();
		return kinds;
	}

	public Message addKind(Kind kind) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		Kind kind1=kindDao.findByType(kind.getType());
		if (kind1==null) {
			String id=UUID.randomUUID().toString().substring(0, 4);
			kind.setId(id);
		    kindDao.addKind(kind);
		    msg.setKind(kind);
		    msg.setMsg("添加新类型成功！");
		    return msg;
		}else {
			msg.setMsg("该类型已经存在！");
			return msg;
		}
	}

	public Message updateKind(Kind kind) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		Kind kind1=kindDao.findByType(kind.getType());
		if (kind1==null) {
			kindDao.updateKind(kind);
			msg.setMsg("修改类型成功！");
			msg.setKind(kind);
			return msg;
		}else {
			msg.setMsg("该类型已经存在！");
			return msg;
		}					
	}

	private Message updateNews( News news , String type) {
		// TODO Auto-generated method stub
		Message msg =new Message();
		Kind kind = kindDao.findByType(type);
		if (kind!=null) {
			News news1 = newsDao.findById(news.getId());
			if (news1!=null) {
				news.setKind(kind);
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
	public Message deleteById(String kId) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		Kind kind=kindDao.finById(kId);
		if (kind!=null) {
		    List<News> newss=newsDao.findBykId(kId);
		    for (News news : newss) {
				news.setKind(null);
				newsDao.updateNews(news);
			}
		    kindDao.deleteById(kind);
			msg.setMsg("删除成功！");
			return msg;
		}else {
			msg.setMsg("该对象不存在！");
			return msg;
		}				
	  }


	}
