package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.LogIn;

public interface LogInDAO extends DAO {
	void insert(LogIn logIn) throws Exception;
	void delete(LogIn logIn) throws Exception;
	void update(LogIn logIn) throws Exception;
	LogIn select(int id) throws Exception;
	LogIn select(String key, String value) throws Exception;
	List<LogIn> selectAll() throws Exception;
	List<LogIn> selectAll(String condition) throws Exception;
}
