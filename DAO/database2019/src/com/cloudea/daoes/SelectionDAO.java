package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Selection;

public interface SelectionDAO extends DAO {
	void insert(Selection selection) throws Exception;
	void delete(Selection selection) throws Exception;
	void update(Selection selection) throws Exception;
	Selection select(int id) throws Exception;
	Selection select(String key, String value) throws Exception;
	List<Selection> selectAll() throws Exception;
	List<Selection> selectAll(String condition) throws Exception;
}
