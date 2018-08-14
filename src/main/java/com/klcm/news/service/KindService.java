package com.klcm.news.service;

import java.util.List;

import com.klcm.news.pojo.Kind;
import com.klcm.news.pojo.Message;



/**
 * 新闻分类服务层接口
 * @author 王雨婷
 *
 */
public interface KindService {

	List<Kind> findAll();

	Message addKind(Kind kind);

	Message updateKind(Kind kind);

	Message deleteById(String kId);

}
