package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Student;

public interface StudentDAO extends DAO {
	void insert(Student student) throws Exception;
	void delete(Student student) throws Exception;
	void update(Student student) throws Exception;
	Student select(int id) throws Exception;
	Student select(String key, String value) throws Exception;
	List<Student> selectAll() throws Exception;
	List<Student> selectAll(String condition) throws Exception;
}
