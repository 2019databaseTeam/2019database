package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.User;

public interface UserDAO extends DAO {
	void insert(User user) throws Exception;
	void delete(User user) throws Exception;
	void update(User user) throws Exception;
	User select(int id) throws Exception;
	User select(String key, String value) throws Exception;
	List<User> selectAll() throws Exception;
	List<User> selectAll(String condition) throws Exception;
}
