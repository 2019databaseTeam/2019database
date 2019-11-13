package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Major;

public interface MajorDAO extends DAO {
	void insert(Major major) throws Exception;
	void delete(Major major) throws Exception;
	void update(Major major) throws Exception;
	Major select(int id) throws Exception;
	Major select(String key, String value) throws Exception;
	List<Major> selectAll() throws Exception;
	List<Major> selectAll(String condition) throws Exception;
}
