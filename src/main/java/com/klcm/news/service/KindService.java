package com.klcm.news.service;

import java.util.List;

import com.klcm.news.pojo.Kind;
import com.klcm.news.pojo.Message;



/**
 * ���ŷ�������ӿ�
 * @author ������
 *
 */
public interface KindService {

	List<Kind> findAll();

	Message addKind(Kind kind);

	Message updateKind(Kind kind);

	Message deleteById(String kId);

}
