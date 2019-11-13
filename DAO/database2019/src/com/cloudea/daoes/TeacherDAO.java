package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Teacher;

public interface TeacherDAO extends DAO {
	void insert(Teacher teacher) throws Exception;
	void delete(Teacher teacher) throws Exception;
	void update(Teacher teacher) throws Exception;
	Teacher select(int id) throws Exception;
	Teacher select(String key, String value) throws Exception;
	List<Teacher> selectAll() throws Exception;
	List<Teacher> selectAll(String condition) throws Exception;
}
