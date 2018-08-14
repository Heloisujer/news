package com.klcm.news.dao;

import java.util.List;

import com.klcm.news.pojo.Kind;

/**
 * ���ŷ������ݲ�ӿ�
 * @author ������
 *
 */
public interface KindDao {

	List<Kind> findAll();

	Kind findByType(String type);

	void addKind(Kind kind);

	void updateKind(Kind kind);

	Kind finById(String kId);

	void deleteById(Kind kind);

}
