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
 * ���ŷ�������
 * @author ������
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
		    msg.setMsg("��������ͳɹ���");
		    return msg;
		}else {
			msg.setMsg("�������Ѿ����ڣ�");
			return msg;
		}
	}

	public Message updateKind(Kind kind) {
		// TODO Auto-generated method stub
		Message msg=new Message();
		Kind kind1=kindDao.findByType(kind.getType());
		if (kind1==null) {
			kindDao.updateKind(kind);
			msg.setMsg("�޸����ͳɹ���");
			msg.setKind(kind);
			return msg;
		}else {
			msg.setMsg("�������Ѿ����ڣ�");
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
				msg.setMsg("�޸ĳɹ���");
				return msg;
			}else {
				msg.setMsg("�����Ų����ڣ�");
				return msg;
			}
		}else {
			msg.setMsg("���������Ͳ����ڣ�");
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
			msg.setMsg("ɾ���ɹ���");
			return msg;
		}else {
			msg.setMsg("�ö��󲻴��ڣ�");
			return msg;
		}				
	  }


	}
