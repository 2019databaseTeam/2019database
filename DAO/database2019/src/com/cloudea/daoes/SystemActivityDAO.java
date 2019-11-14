package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.SystemActivity;

public interface SystemActivityDAO extends DAO {
	void insert(SystemActivity systemActivity) throws Exception;
	void delete(SystemActivity systemActivity) throws Exception;
	void update(SystemActivity systemActivity) throws Exception;
	SystemActivity select(int id) throws Exception;
	SystemActivity select(String key, String value) throws Exception;
	List<SystemActivity> selectAll() throws Exception;
	List<SystemActivity> selectAll(String condition) throws Exception;
}
